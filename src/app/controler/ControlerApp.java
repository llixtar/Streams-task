package app.controler;

import app.view.ViewApp;
import app.model.ModelUsersApp;
import app.entity.User;
import app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ControlerApp {

    ModelUsersApp model = new ModelUsersApp();
    ViewApp view = new ViewApp();

    public void runApp() {

        List<User> users = model.getUsers();
        Stream<User> usersStream = users.stream();

        String optionInput = view.getOption();
        String optionInputValidated = model.validateOptionInput(optionInput);

        try {
            switch (Integer.parseInt(optionInputValidated)) {
                case 1 -> filteredVodafone(usersStream);
                case 2 -> filteredKyivstar(usersStream);
                case 3 -> filteredLifecell(usersStream);
                case 4 -> showSubscribers(usersStream);
                case 5 -> filteredEMailes123(usersStream);
                case 0 -> {
                    view.getOutput("App closed.");
                    System.exit(0);
                }
                default -> view.getOutput("Wrong option " + optionInputValidated + " ! Try again.");
            }
        } catch (NumberFormatException e) {
            view.getOutput(optionInputValidated);
        }
    }

    private void filteredVodafone(Stream<User> usersStream) {
        Stream<User> filteredData = usersStream.filter(user -> {
            String phone = user.getPhone();
            return phone.contains(Constants.VODAFONE[Constants.VODAFONE_050])
                    || phone.contains(Constants.VODAFONE[Constants.VODAFONE_066])
                    || phone.contains(Constants.VODAFONE[Constants.VODAFONE_095])
                    || phone.contains(Constants.VODAFONE[Constants.VODAFONE_099]);
        });

        showSubscribers(filteredData);
    }

    private void filteredKyivstar(Stream<User> usersStream) {
        Stream<User> filteredData = usersStream.filter(user -> {
            String phone = user.getPhone();
            return phone.contains(Constants.KYIVSTAR[Constants.KYIVSTAR_067])
                    || phone.contains(Constants.KYIVSTAR[Constants.KYIVSTAR_068])
                    || phone.contains(Constants.KYIVSTAR[Constants.KYIVSTAR_096])
                    || phone.contains(Constants.KYIVSTAR[Constants.KYIVSTAR_097])
                    || phone.contains(Constants.KYIVSTAR[Constants.KYIVSTAR_098]);
        });
        showSubscribers(filteredData);
    }

    private void filteredLifecell(Stream<User> usersStream) {
        Stream<User> filteredData = usersStream.filter(user -> {
            String phone = user.getPhone();
            return phone.contains(Constants.LIFECELL[Constants.LIFECELL_063])
                    || phone.contains(Constants.LIFECELL[Constants.LIFECELL_073])
                    || phone.contains(Constants.LIFECELL[Constants.LIFECELL_093]);
        });
        showSubscribers(filteredData);
    }

    private void filteredEMailes123(Stream<User> usersStream) {
        Stream<User> filteredData = usersStream.filter(user ->
                user.geteMail().contains("123")
        );

        showSubscribers(filteredData);
    }

    private void showSubscribers(Stream<User> data) {
        AtomicInteger count = new AtomicInteger(0);
        data.forEach(usr ->
                view.getOutput(String.format("%d) %s ", count.incrementAndGet(), usr)));

    }
}
