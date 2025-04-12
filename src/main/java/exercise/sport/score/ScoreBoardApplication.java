package exercise.sport.score;

import exercise.sport.score.service.ApplicationService;
import exercise.sport.score.service.ScoreBoardService;
import exercise.sport.score.service.VerificationService;

import java.util.*;

public class ScoreBoardApplication {

    public static void main(String[] args) {
        startApplication();
    }

    public static List<String> startApplication() {
        ScoreBoardService scoreBoardService = new ScoreBoardService();
        VerificationService verificationService = new VerificationService();
        ApplicationService applicationService = new ApplicationService(scoreBoardService, verificationService);

        return applicationService.runApplication();
    }
}
