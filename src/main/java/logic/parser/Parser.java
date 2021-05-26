package logic.parser;

import java.util.ArrayList;

import static util.ErrorConstants.EMPTY_TOWNS_ERROR;
import static util.ErrorConstants.INTEGER_NOT_FOUND_ERROR;

public class Parser {

    /**
     * Parses town names from user input
     * @param input user input containing valid town names
     * @return a list of town names
     */
    public static ArrayList<String> parseTownNames(String input) throws Exception {
        ArrayList<String> townNames = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            String townName = Character.toString(c);
            if (Character.isLetter(c)) {
                townNames.add(townName);
            }
        }

        if (townNames.size() == 0) {
            throw new Exception(EMPTY_TOWNS_ERROR);
        }

        return townNames;
    }

    /**
     * Parses an integer from user input
     * @param input user input containing at least one integer
     * @return an integer
     */
    public static int parseNumericValue(String input) throws Exception {
        String[] inputSplit = input.split(" ");
        String numString = inputSplit[inputSplit.length - 1];

        try {
            return Integer.parseInt(numString);
        } catch (NumberFormatException e) {
            throw new Exception(INTEGER_NOT_FOUND_ERROR);
        }
    }
}
