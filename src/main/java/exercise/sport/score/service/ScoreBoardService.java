package exercise.sport.score.service;

import exercise.sport.score.model.Match;
import exercise.sport.score.model.Score;

import java.util.LinkedHashMap;
import java.util.Map;

public class ScoreBoardService {

    public void handleStartCommand(Map<Match, Score> scoreBoard, Match match){
        scoreBoard.put(match, new Score("0", "0"));
        printScoreBoard(scoreBoard);
    }

    public void handleFinishCommand(Map<Match, Score> scoreBoard, Match match){
        scoreBoard.remove(match);
        printScoreBoard(scoreBoard);
    }

    public void handleUpdateCommand(Map<Match, Score> scoreBoard, Match match, Score score) {
        scoreBoard.put(match, score);
        printScoreBoard(scoreBoard);
    }

    public Map<Match, Score> handleTotalCommand(Map<Match, Score> scoreBoard) {
        return new LinkedHashMap<>();
    }

    private void printScoreBoard(Map<Match, Score> scoreBoard) {
        scoreBoard.entrySet().forEach(
                entry -> {
                    System.out.println(entry.getKey().toString() + ":" + entry.getValue().toString());
                }
        );
    }
}
