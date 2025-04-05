package exercise.sport.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreBoardApplication {

    static String END_COMMAND = "exit";

    public static void main(String[] args) {
        startApplication();
    }

    public static List<String> startApplication() {
        List<String> commands = new ArrayList<>();
        String command = "start";
        Scanner scanner = new Scanner(System.in);
        while(!command.equals(END_COMMAND)) {
            command = scanner.nextLine();
            commands.add(command);
        }
        return commands;
    }
}
