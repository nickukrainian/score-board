package exercise.sport.score.model;

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
}
