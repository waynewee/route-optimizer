package logic.parser;

import model.TownList;
import model.query.*;

import java.util.ArrayList;

import static util.ErrorConstants.INVALID_KEYWORD_ERROR;
import static util.ErrorConstants.INVALID_QUERY_ERROR;

/**
 * Parses a user input for a valid query
 */
public class QueryParser extends Parser {

    private static final String distanceCalcKeyword = "dst";
    private static final String routeCtrByStops = "rcs";
    private static final String routeCtrByExactStops =  "rce";
    private static final String shortestRouteKeyword = "src";
    private static final String routeCtrByDistance = "rcd";

    /**
     * Parses the user input for a query keywords and arguments
     * @param townList list of towns
     * @param queryString user input
     * @return a query object
     */
    public static Query parseQuery(TownList townList, String queryString) throws Exception {
        String[] querySplit = queryString.split(" ", 2);

        if (querySplit.length < 2) {
           throw new Exception(INVALID_QUERY_ERROR);
        }

        String keyword = querySplit[0];
        String args = querySplit[1];

        ArrayList<String> townNames = parseTownNames(args);
        ArrayList<Integer> townIds = townList.mapTownNamesToIds(townNames);

        switch (keyword) {
            case distanceCalcKeyword:
                return new DistanceCalculatorQuery(townIds);
            case routeCtrByStops:
                return new RouteCounterByStopsQuery(townIds.get(0), townIds.get(1), parseNumericValue(args));
            case routeCtrByExactStops:
                return new RouteCounterByExactStopsQuery(townIds.get(0), townIds.get(1), parseNumericValue(args));
            case shortestRouteKeyword:
                return new ShortestRouteCalculatorQuery(townIds.get(0), townIds.get(1));
            case routeCtrByDistance:
                return new RouteCounterByDistanceQuery(townIds.get(0), townIds.get(1), parseNumericValue(args));
            default:
                throw new Exception(INVALID_KEYWORD_ERROR);
        }

    }
}
