package exercise.sport.score.service;

import exercise.sport.score.model.Match;
import exercise.sport.score.model.Score;

import java.util.*;

public class ApplicationService {

    static String END_COMMAND = "exit";

    final static String START_COMMAND = "start";
    final static String FINISH_COMMAND = "finish";
    final static String UPDATE_COMMAND = "update";
    final static String TOTAL_COMMAND = "total";

    private final ScoreBoardService scoreBoardService;
    private final VerificationService verificationService;

    public ApplicationService(ScoreBoardService scoreBoardService, VerificationService verificationService) {
        this.scoreBoardService = scoreBoardService;
        this.verificationService = verificationService;
    }

    public List<String> runApplication(){
        List<String> commands = new ArrayList<>();
        Map<Match, Score> scoreBoard = new LinkedHashMap<>();
        String command = "start";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Score board application");
        while (!command.equalsIgnoreCase(END_COMMAND)) {
            command = scanner.nextLine();
            commands.add(command);

            switch (command.toLowerCase()) {
                case START_COMMAND -> handleStartCommand(scanner, scoreBoard);
                case FINISH_COMMAND -> handleFinishCommand(scanner, scoreBoard);
                case UPDATE_COMMAND -> handleUpdateCommand(scanner, scoreBoard);
                case TOTAL_COMMAND -> handleTotalCommand(scoreBoard);
            }
        }
        return commands;
    }

    private void handleStartCommand(Scanner scanner, Map<Match, Score> scoreBoard) {
        System.out.println("Home team: ");
        String homeTeam = scanner.nextLine();
        System.out.println("Away team: ");
        String awayTeam = scanner.nextLine();
        Match match = new Match(homeTeam, awayTeam);
        System.out.println(match);
        scoreBoardService.handleStartCommand(scoreBoard, match);
    }

    private void handleFinishCommand(Scanner scanner, Map<Match, Score> scoreBoard) {
        System.out.println("Home team: ");
        String homeTeam = scanner.nextLine();
        System.out.println("Away team: ");
        String awayTeam = scanner.nextLine();
        Match match = new Match(homeTeam, awayTeam);
        scoreBoardService.handleFinishCommand(scoreBoard, match);
    }

    private void handleUpdateCommand(Scanner scanner, Map<Match, Score> scoreBoard) {
        System.out.println("Home team: ");
        String homeTeam = scanner.nextLine();
        System.out.println("Away team: ");
        String awayTeam = scanner.nextLine();
        System.out.println("Home score: ");
        String homeScore = scanner.nextLine();
        try {
            verificationService.verifyScore(homeScore);
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid argument for home score");
        }
        System.out.println("Away score: ");
        String awayScore = scanner.nextLine();
        try {
            verificationService.verifyScore(awayScore);
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid argument for home score");
        }
        try {
            Match match = new Match(homeTeam, awayTeam);
            Score score = new Score(Integer.parseInt(homeScore), Integer.parseInt(awayScore));
            scoreBoardService.handleUpdateCommand(scoreBoard, match, score);
        } catch (NumberFormatException exception) {
            System.out.println("Invalid score");
        }

    }

    private void handleTotalCommand(Map<Match, Score> scoreBoard) {
        Map<Match, Score> sortedScoreBoard = scoreBoardService.handleTotalCommand(scoreBoard);
        sortedScoreBoard.entrySet().forEach(
                entry -> {
                    System.out.println(entry.getKey().toString() + ":" + entry.getValue().toString());
                }
        );

    }
}
