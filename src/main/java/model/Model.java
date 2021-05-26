package model;

import logic.algo.DistanceCalculator;
import logic.algo.RouteCounterByDistance;
import logic.algo.RouteCounterByStops;
import logic.algo.ShortestRouteCalculator.ShortestRouteCalculator;

public class Model {

    private final TownList townList;
    private final RouteList routeList;
    private final Matrix matrix;
    public final ShortestRouteCalculator shortestRouteCalculator;
    public final RouteCounterByStops routeCounterByStops;
    public final DistanceCalculator distanceCalculator;
    public final RouteCounterByDistance routeCounterByDistance;

    public Model(TownList townList, RouteList routeList, Matrix matrix) {
        this.townList = townList;
        this.routeList = routeList;
        this.matrix = matrix;
        this.shortestRouteCalculator = new ShortestRouteCalculator(matrix);
        this.routeCounterByDistance = new RouteCounterByDistance(matrix);
        this.distanceCalculator = new DistanceCalculator(matrix);
        this.routeCounterByStops = new RouteCounterByStops(matrix);
    }

    public TownList getTownList() {
        return townList;
    }

    public RouteList getRouteList() {
        return routeList;
    }

    public Matrix getMatrix() {
        return matrix;
    }
}
