package exercise.sport.score.service;

import java.util.regex.Pattern;

public class VerificationService {

    public void verifyScore(String score) {
        Pattern pattern = Pattern.compile("\\d{1,3}");
        if (!pattern.matcher(score).matches()) throw new IllegalArgumentException("Invalid argument for score: " +score);
    }

}
