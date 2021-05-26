package model.query;

import model.Model;

public class RouteCounterByDistanceQuery extends Query {

    int u, v, k;

    public RouteCounterByDistanceQuery(int u, int v, int k) {
        queryType = QueryType.ROUTE_COUNTER_BY_DISTANCE;
        this.u = u;
        this.v = v;
        this.k = k;
    }

    public String execute(Model model) {
        int numRoutes = model.routeCounterByDistance.countRoutes(u, v, k);
        return String.valueOf(numRoutes);
    }

}
