package logic.parser;

import model.Route;
import model.RouteList;
import model.Town;
import model.TownList;

import java.util.*;

import static util.ErrorConstants.PARSE_ERROR_SOURCE;

/**
 * Parses the input string and extracts town
 * and route information
 */
public class ModelParser extends Parser{

    /**
     * Parses the input string and extracts towns
     * @param input user input containing valid town names
     * @return a list of towns
     */
    public static TownList parseTowns(String input) throws Exception {
        TownList townList = new TownList();
        ArrayList<String> townNames = parseTownNames(input);

        for (String townName: townNames) {
            townList.addTown(new Town(townName));
        }

        return townList;
    }

    /**
     * Parses the input string and extracts routes
     * @param input user input containing valid routes
     * @param townList list of towns
     * @return a list of routes
     */
    public static RouteList parseRoutes(String input, TownList townList) throws Exception {

        RouteList routeList = new RouteList();
        try {
            String[] routeStrings = Arrays.stream(input.split(" "))
                            .map(String::trim)
                            .toArray(String[]::new);
            for (String routeString: routeStrings) {
                Town from = townList.getTownByName(Character.toString(routeString.charAt(0)));
                Town to = townList.getTownByName(Character.toString(routeString.charAt(1)));
                int distance = Integer.parseInt(routeString.substring(2));
                routeList.addRoute(new Route(from, to, distance));
            }

            return routeList;
        } catch (Exception e) {
            throw new Exception(PARSE_ERROR_SOURCE);
        }

    }

}
