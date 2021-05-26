package model;

import java.util.ArrayList;

public class RouteList {

    private final ArrayList<Route> routes = new ArrayList<>();

    public void addRoute(Route route) {
        if (!routes.contains(route)) {
            routes.add(route);
        }
    }

    public ArrayList<Route> getRoutes() {
        return routes;
    }

    @Override
    public String toString(){
        return routes.toString();
    }

}
