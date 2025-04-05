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
    void name() {
    }
}