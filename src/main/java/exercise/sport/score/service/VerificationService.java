package exercise.sport.score.service;

import java.util.regex.Pattern;

public class VerificationService {

    public void verifyScore(String score) {
        Pattern pattern = Pattern.compile("\\d{3}");
        if (!pattern.matcher(score).matches()) throw new IllegalArgumentException();
    }

}
