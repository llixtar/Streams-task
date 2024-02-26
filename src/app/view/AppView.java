package app.view;

import java.util.Scanner;

public class AppView {

    private final Scanner scanner = new Scanner(System.in);

    public String getOption() {
        System.out.print(
                """
                OPTIONS
                1 - Show Vodafone subscribers.
                2 - Show Kyivstar subscribers.
                3 - Show Lifecell subscribers.
                4 - Show all subscribers.
                5 - Show e-mailes with 123
                0 - Exit.
                """
        );
        System.out.print("Input your option: ");
        return scanner.nextLine().trim();
    }

    public void getOutput(String output) {
        System.out.println(output);
    }

}
