package app.utils;

public class AppValidator {

    // Регулярний вираз. Можна тільки цілі позитивні числа
    public static final String INPUT_REGEX = "^\\d+$";

    public String validateOptionInput(String strOptionInput) throws IllegalArgumentException {
        if (!strOptionInput.matches(INPUT_REGEX))
            throw new IllegalArgumentException("Option input " + strOptionInput
                    + " is invalid!");
        return strOptionInput;
    }


}
