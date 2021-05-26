package model.query;

import model.Model;

public class RouteCounterByStopsQuery extends Query {

    int u, v, k;
    public RouteCounterByStopsQuery(int u, int v, int k) {
        queryType = QueryType.ROUTE_COUNTER_BY_STOPS;
        this.u = u;
        this.v = v;
        this.k = k;
    }

    public String execute(Model model) {
        int answer = model.routeCounterByStops.countStops(u, v, k);
        return String.valueOf(answer);
    }

}
