package model.query;

import model.Model;

public abstract class Query {

    public enum QueryType {
        DISTANCE_CALC,
        ROUTE_COUNTER_BY_STOPS,
        ROUTE_COUNTER_BY_EXACT_STOPS,
        SHORTEST_ROUTE,
        ROUTE_COUNTER_BY_DISTANCE
    }

    public QueryType queryType;

    public abstract String execute(Model model) throws Exception;


}
