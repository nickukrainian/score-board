package exercise.sport.score.model;

import java.util.Objects;

public class Score {

    String homeScore;

    String awayScore;

    public Score() {
    }

    public Score(String homeScore, String awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(String awayScore) {
        this.awayScore = awayScore;
    }

    @Override
    public String toString() {
        return homeScore + '-' + awayScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return Objects.equals(homeScore, score.homeScore) && Objects.equals(awayScore, score.awayScore);
    }
}
