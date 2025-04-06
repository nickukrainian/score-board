package exercise.sport.score;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class ScoreBoardApplicationTest {

    static String END_COMMAND = "exit";

    @Test
    void should_end_program_with_end_command() {
        String[] inputLines = new String[]{
                "First command",
                "Second Command",
                END_COMMAND,
                "Additional command"
        };

        String[] expectedLines = Arrays.copyOf(inputLines, inputLines.length - 1);
        List<String> expectedLinesList = Arrays.stream(expectedLines).toList();

        InputStream inputStream = System.in;

        try {
            System.setIn(new ByteArrayInputStream(String.join("\n", inputLines).getBytes()));
            List<String> actualLinesList = ScoreBoardApplication.startApplication();
            assertThat(actualLinesList).isEqualTo(expectedLinesList);
        } finally {
            System.setIn(inputStream);
        }

    }
}
