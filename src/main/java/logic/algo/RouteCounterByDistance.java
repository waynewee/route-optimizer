package logic.algo;

import model.Matrix;

/**
 * Counts the number of different routes from
 * one town to another with a distance of less than k
 */
public class RouteCounterByDistance {

    private final Matrix matrix;
    private int numRoutes;

    public RouteCounterByDistance(Matrix matrix) {
        this.matrix = matrix;
    }

    /**
     * Counts the number of routes from u to v of distance less than k
     * @param u index of start town
     * @param v index of end town
     * @param k maximum distance
     * @return number of routes
     */
    public int countRoutes(int u, int v, int k) {
        numRoutes = 0;
        countRoutesAux(u, v, k - 1, true);
        return numRoutes;
    }

    private void countRoutesAux(int u, int v, int k, boolean isFirstPass) {
        if (k <= 0) {
            return;
        }
        if (u == v && !isFirstPass) {
            numRoutes++;
        }
        int[] l = matrix.data[u];
        for (int i = 0; i < l.length; i++ ){
            if (l[i] > 0) {
                countRoutesAux(i, v, k - l[i], false);
            }
        }
    }


}
