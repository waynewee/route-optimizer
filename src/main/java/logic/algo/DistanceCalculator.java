package logic.algo;

import model.Matrix;

import java.util.ArrayList;

import static util.ErrorConstants.NO_SUCH_ROUTE_ERROR;

/**
 * Calculates the distance of a given route
 */
public class DistanceCalculator {

    private final Matrix matrix;

    public DistanceCalculator(Matrix matrix){
        this.matrix = matrix;
    }

    /**
     * Calculates the distance of a given route specified by townIds
     * @param townIds list of town identifiers
     * @return distance of given route
     */
    public int calculateDistance(ArrayList<Integer> townIds) throws Exception {

        int totalDistance = 0;

        for (int i = 0; i < townIds.size() - 1; i++) {
            int distance = matrix.data[townIds.get(i)][townIds.get(i+1)];
            if (distance == 0) {
                throw new Exception(NO_SUCH_ROUTE_ERROR);
            }
            totalDistance += distance;
        }

        return totalDistance;

    }

}
