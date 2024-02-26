package app.model;

import app.entity.User;
import app.utils.AppValidator;

import java.util.Arrays;
import java.util.List;

public class ModelUsersApp {
    public List<User> getUsers() {
        return Arrays.asList(
                new User("Yaroslav", "050 576 38 36", "yarik@gmail.com"),
                new User("Max", "067 258 32 78", "maxim@gmail.com"),
                new User("Tanya", "063 005 83 12", "tanya@gmail.com"),
                new User("Sergiy", "066 742 56 00", "sergo@gmail.com"),
                new User("Kira", "068 901 00 12", "kirrra@gmail.com"),

                new User("Dima", "073 657 67 36", "dimon@gmail.com"),
                new User("Mihajlo", "095 786 23 90", "mixa@gmail.com"),
                new User("Anna", "096 143 83 56", "anna123@gmail.com"),
                new User("Rita", "093 876 56 11", "ritok@gmail.com"),
                new User("Grigoriy", "099 666 78 21", "gregorNeMac@gmail.com"),

                new User("Alla", "097 890 00 00", "allo4ka@gmail.com"),
                new User("Olexiy", "098 000 11 65", "olek123@gmail.com"),
                new User("Alina", "073 456 89 12", "alinka@gmail.com"),
                new User("Irina", "050 765 43 76", "ira@gmail.com"),
                new User("Kirill", "063 879 23 76", "kirill@gmail.com")


        );
    }

    public String validateOptionInput(String input) {
        AppValidator validator = new AppValidator();
        try {
            return validator.validateOptionInput(input);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
