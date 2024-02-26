package app.controler;

import app.utils.Constants;
import app.view.AppView;
import app.model.ApplUsersMode;
import app.entity.User;

import java.util.List;

import java.util.stream.Stream;

public class AppControler {

    ApplUsersMode model = new ApplUsersMode();
    AppView view = new AppView();

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
                case 5 -> filteredEMailes123(usersStream, Constants.SERCH_WORD);
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
        output(model.filteredVodafone(usersStream));
    }

    private void filteredKyivstar(Stream<User> usersStream) {
        output(model.filteredKyivstar(usersStream));
    }

    private void filteredLifecell(Stream<User> usersStream) {
        output(model.filteredLifecell(usersStream));
    }

    private void filteredEMailes123(Stream<User> usersStream, String word) {
        output(model.filteredEMailes123(usersStream, word));
    }

    private void showSubscribers(Stream<User> data) {
        output(model.showSubscribers(data));
    }

    private void output(List<String> outputList) {
        for (String user : outputList) view.getOutput(user);
    }
}
