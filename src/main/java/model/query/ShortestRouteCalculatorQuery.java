package model.query;

import model.Model;

public class ShortestRouteCalculatorQuery extends Query {

    int u, v;

    public ShortestRouteCalculatorQuery(int u, int v) {
        queryType = QueryType.SHORTEST_ROUTE;
        this.u = u;
        this.v = v;
    }

    public String execute(Model model) {
        int answer = model.shortestRouteCalculator.calculateShortestRoute(u, v);
        return String.valueOf(answer);

    }

}
