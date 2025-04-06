package exercise.sport.score.service;

import exercise.sport.score.model.Match;
import exercise.sport.score.model.Score;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreBoardServiceTest {

    ScoreBoardService service = new ScoreBoardService();

    @Test
    void should_handle_start_command() {
        Map<Match, Score> scoreBoard = new LinkedHashMap<>();
        Match match = new Match("A", "B");
        service.handleStartCommand(scoreBoard, match);

        Score score = new Score("0", "0");

        assertThat(scoreBoard).containsKey(match);
        assertThat(scoreBoard.get(match)).isEqualTo(score);
    }

    @Test
    void should_handle_finish_command() {
        Map<Match, Score> scoreBoard = new LinkedHashMap<>();
        Match match = new Match("A", "B");
        service.handleStartCommand(scoreBoard, match);

        service.handleFinishCommand(scoreBoard, match);

        assertThat(scoreBoard).hasSize(0);
    }

    @Test
    void should_handle_update_command() {
        Map<Match, Score> scoreBoard = new LinkedHashMap<>();
        Match match = new Match("A", "B");
        service.handleStartCommand(scoreBoard, match);

        Score score = new Score("1", "0");

        service.handleUpdateCommand(scoreBoard, match, score);

        assertThat(scoreBoard.get(match)).isEqualTo(score);
    }

    @Test
    void should_handle_total_command() {
        Map<Match, Score> scoreBoard = new LinkedHashMap<>();
        scoreBoard.put(new Match("A", "B"), new Score("1", "2"));
        scoreBoard.put(new Match("C", "D"), new Score("5", "5"));
        scoreBoard.put(new Match("E", "F"), new Score("8", "2"));

        Map<Match, Score> expectedScoreBoard = new LinkedHashMap<>();
        expectedScoreBoard.put(new Match("C", "D"), new Score("5", "5"));
        expectedScoreBoard.put(new Match("E", "F"), new Score("8", "2"));
        expectedScoreBoard.put(new Match("A", "B"), new Score("1", "2"));

        Map<Match, Score> actualScoreBoard = service.handleTotalCommand(scoreBoard);

        assertThat(actualScoreBoard).containsExactlyEntriesOf(expectedScoreBoard);
    }
}