package logic.algo;

import model.Matrix;

/**
 * Counts the number of different routes from
 * one town to another depending on the number of stops
 * in the route.
 */
public class RouteCounterByStops {

    private final Matrix matrix;

    public RouteCounterByStops(Matrix matrix) {
        this.matrix = matrix;
    }

    /**
     * Counts the number of different routes from u to v with
     * exactly k stops
     * @param u index of start town
     * @param v index of end town
     * @param k number of stops
     * @return number of routes
     */
    public int countExactStops(int u, int v, int k) {
        return countTripsAux(u, v, k);
    }

    /**
     * Counts the number of different routes from u to v with
     * a maximum of k stops
     * @param u index of start town
     * @param v index of end town
     * @param k number of stops
     * @return number of routes
     */
    public int countStops(int u, int v, int k) {
        int totalStops = 0;
        for (int i = 1; i <= k; i++) {
            totalStops += countTripsAux(u, v, i);
        }
        return totalStops;
    }

    private int countTripsAux(int u, int v, int k) {

        if (k == 0 && u == v) {
            return 1;
        }
        if (k == 1 && matrix.data[u][v] > 0) {
            return 1;
        }
        if (k <= 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < matrix.size; i++) {
            if (matrix.data[u][i] > 0) {
                count += countTripsAux(i, v, k - 1);
            }
        }
        return count;
    }

}
