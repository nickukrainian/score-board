package exercise.sport.score.service;

import exercise.sport.score.model.Match;
import exercise.sport.score.model.Score;

import java.util.Map;

public class ScoreBoardService {

    public void handleStartCommand(Map<Match, Score> scoreBoard, Match match){
        scoreBoard.put(match, new Score("0", "0"));
        printScoreBoard(scoreBoard);
    }

    private void printScoreBoard(Map<Match, Score> scoreBoard) {
        scoreBoard.entrySet().forEach(
                entry -> {
                    System.out.println(entry.getKey().toString() + ":" + entry.getValue().toString());
                }
        );
    }
}
