package exercise.sport.score.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerificationServiceTest {

    VerificationService service = new VerificationService();

    @Test
    void should_throw_exception_when_verification_is_not_passed() {
        assertThrows(IllegalArgumentException.class, () -> service.verifyScore("zero"));
    }
}