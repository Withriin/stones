package stonesLibrary;

import java.util.Locale;

public class Validation {
    public static boolean userPlayGameInputValidator(String userPlayGameInput) {
        int parsedInt = Integer.parseInt(userPlayGameInput);
        if (parsedInt == 1 || parsedInt == 2) {
            if (parsedInt == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new RuntimeException("Invalid Input.");
        }
    }

    public static int playerChoiceConverter(String playerInput){
        int parsedInput = Integer.parseInt(playerInput);
        return parsedInput;
    }

    public static CoinFlip userCoinFlipInputValidator(String userInput) {
        userInput = userInput.toUpperCase();
        if (userInput.contains("H") && userInput.length() == 1) {
            return CoinFlip.HEADS;
        } else if (userInput.contains("T") && userInput.length() == 1) {
            return CoinFlip.TAILS;
        } else {
            throw new RuntimeException("Invalid Input. ");
        }
    }
}
