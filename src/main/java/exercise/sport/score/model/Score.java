package exercise.sport.score.model;

import java.util.Objects;

public class Score {

    Integer homeScore;

    Integer awayScore;

    public Score() {
    }

    public Score(Integer homeScore, Integer awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    @Override
    public String toString() {
        return homeScore.toString() + '-' + awayScore.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return Objects.equals(homeScore, score.homeScore) && Objects.equals(awayScore, score.awayScore);
    }
}
