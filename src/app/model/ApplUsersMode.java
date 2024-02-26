package app.model;

import app.entity.User;
import app.utils.AppValidator;
import app.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ApplUsersMode {
    public List<User> getUsers() {
        return Arrays.asList(
                new User("Yaroslav", "050 097 38 36", "yarik@gmail.com"),
                new User("Max", "067 063 32 78", "maxim@gmail.com"),
                new User("Tanya", "063 068 83 12", "tanya@gmail.com"),
                new User("Sergiy", "066 050 56 00", "sergo@gmail.com"),
                new User("Kira", "068 073 00 12", "kirrra@gmail.com"),

                new User("Dima", "073 657 67 36", "dimon@gmail.com"),
                new User("Mihajlo", "095 786 23 90", "mixa@gmail.com"),
                new User("Anna", "096 143 83 56", "anna123@gmail.com"),
                new User("Rita", "093 876 56 11", "ritok@gmail.com"),
                new User("Grigoriy", "099 666 78 21", "gregorNeMac@gmail.com"),

                new User("Alla", "097 890 00 00", "allo4ka@gmail.com"),
                new User("Olexiy", "098 000 11 65", "123olek@gmail.com"),
                new User("Alina", "073 456 89 12", "alinka@gmail.com"),
                new User("Irina", "050 765 43 76", "ira_123_ira@gmail.com"),
                new User("Kirill", "063 879 23 76", "kirill@gmail.com")


        );
    }

    public List<String> showSubscribers(Stream<User> data) {
        List<String> outputList = new ArrayList<>();
        AtomicInteger count = new AtomicInteger(0);

        // Проходимо по кожному користувачу у потоці і формуємо вихідні дані
        data.forEach(usr -> {
            String userData = String.format("%d) %s ", count.incrementAndGet(), usr);
            outputList.add(userData);
        });

        return outputList;
    }

    public List<String> filteredVodafone(Stream<User> usersStream) {
        Stream<User> filteredData = usersStream.filter(user -> {
            String phone = user.getPhone();
            return phone.startsWith(Constants.VODAFONE[Constants.VODAFONE_050])
                    || phone.startsWith(Constants.VODAFONE[Constants.VODAFONE_066])
                    || phone.startsWith(Constants.VODAFONE[Constants.VODAFONE_095])
                    || phone.startsWith(Constants.VODAFONE[Constants.VODAFONE_099]);

        });

        return showSubscribers(filteredData);
    }

    public List<String> filteredKyivstar(Stream<User> usersStream) {
        Stream<User> filteredData = usersStream.filter(user -> {
            String phone = user.getPhone();
            return phone.startsWith(Constants.KYIVSTAR[Constants.KYIVSTAR_067])
                    || phone.startsWith(Constants.KYIVSTAR[Constants.KYIVSTAR_068])
                    || phone.startsWith(Constants.KYIVSTAR[Constants.KYIVSTAR_096])
                    || phone.startsWith(Constants.KYIVSTAR[Constants.KYIVSTAR_097])
                    || phone.startsWith(Constants.KYIVSTAR[Constants.KYIVSTAR_098]);
        });
        return showSubscribers(filteredData);
    }

    public List<String> filteredLifecell(Stream<User> usersStream) {
        Stream<User> filteredData = usersStream.filter(user -> {
            String phone = user.getPhone();
            return phone.startsWith(Constants.LIFECELL[Constants.LIFECELL_063])
                    || phone.startsWith(Constants.LIFECELL[Constants.LIFECELL_073])
                    || phone.startsWith(Constants.LIFECELL[Constants.LIFECELL_093]);
        });
        return showSubscribers(filteredData);
    }

    public List<String> filteredEMailes123(Stream<User> usersStream, String word) {
        Stream<User> filteredData = usersStream.filter(user ->
                user.geteMail().contains(word)
        );

       return showSubscribers(filteredData);
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
