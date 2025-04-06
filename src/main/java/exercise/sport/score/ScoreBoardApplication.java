package exercise.sport.score;

import exercise.sport.score.model.Match;
import exercise.sport.score.model.Score;
import exercise.sport.score.service.ScoreBoardService;

import java.util.*;

public class ScoreBoardApplication {

    static String END_COMMAND = "exit";

    final static String START_COMMAND = "start";
    final static String FINISH_COMMAND = "finish";
    final static String UPDATE_COMMAND = "update";

    static ScoreBoardService scoreBoardService = new ScoreBoardService();

    public static void main(String[] args) {
        startApplication();
    }

    public static List<String> startApplication() {
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
            }
        }
        return commands;
    }


    private static void handleStartCommand(Scanner scanner, Map<Match, Score> scoreBoard) {
        System.out.println("Home team: ");
        String homeTeam = scanner.nextLine();
        System.out.println("Away team: ");
        String awayTeam = scanner.nextLine();
        Match match = new Match(homeTeam, awayTeam);
        System.out.println(match);
        scoreBoardService.handleStartCommand(scoreBoard, match);
    }

    private static void handleFinishCommand(Scanner scanner, Map<Match, Score> scoreBoard) {
        System.out.println("Home team: ");
        String homeTeam = scanner.nextLine();
        System.out.println("Away team: ");
        String awayTeam = scanner.nextLine();
        Match match = new Match(homeTeam, awayTeam);
        scoreBoardService.handleFinishCommand(scoreBoard, match);
    }

    private static void handleUpdateCommand(Scanner scanner, Map<Match, Score> scoreBoard) {
        System.out.println("Home team: ");
        String homeTeam = scanner.nextLine();
        System.out.println("Away team: ");
        String awayTeam = scanner.nextLine();
        System.out.println("Home score: ");
        String homeScore = scanner.nextLine();
        System.out.println("Away score: ");
        String awayScore = scanner.nextLine();
        Match match = new Match(homeTeam, awayTeam);
        Score score = new Score(Integer.parseInt(homeScore), Integer.parseInt(awayScore));
        scoreBoardService.handleUpdateCommand(scoreBoard, match, score);
    }
}
