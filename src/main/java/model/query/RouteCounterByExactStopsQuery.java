package model.query;

import model.Model;

public class RouteCounterByExactStopsQuery extends Query {

    int u, v, k;
    public RouteCounterByExactStopsQuery(int u, int v, int k) {
        queryType = QueryType.ROUTE_COUNTER_BY_EXACT_STOPS;
        this.u = u;
        this.v = v;
        this.k = k;
    }

    public String execute(Model model) {
        int answer = model.routeCounterByStops.countExactStops(u, v, k);
        return String.valueOf(answer);
    }

}
