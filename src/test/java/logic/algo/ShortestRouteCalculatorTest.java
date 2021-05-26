package logic.algo;

import logic.algo.ShortestRouteCalculator.ShortestRouteCalculator;
import model.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static util.ErrorConstants.NO_SUCH_ROUTE_ERROR;

public class ShortestRouteCalculatorTest {

    private static ShortestRouteCalculator shortestRouteCalculator;
    private static Matrix matrix;

    @BeforeAll
    public static void setup(){
        int[][] data = {
                {0, 4, 0, 6, 0, 0, 2, 0, 0, 0, 0},
                {0, 0, 1, 5, 10, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 4, 7, 0, 0},
                {0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 8},
                {0, 0, 2, 0, 0, 0, 0, 0, 7, 0, 0},
                {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 5, 14, 0, 0, 0, 0, 4},
                {0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 3, 0},
                {0, 0, 0, 0, 0, 0, 12, 12, 0, 0, 0},
                {0, 0, 0, 0, 0, 7, 4, 0, 0, 0, 0}
        };
        Matrix matrix = new Matrix(data);
        shortestRouteCalculator = new ShortestRouteCalculator(matrix);
    }

    @Test
    public void calculateShortestRoute_Route0To5_ReturnsShortestRouteLength() {
        int shortestRoute = shortestRouteCalculator.calculateShortestRoute(0, 5);
        Assertions.assertEquals(13, shortestRoute);
    }

    @Test
    public void calculateShortestRoute_Route8To4_ReturnsShortestRouteLength() {
        int shortestRoute = shortestRouteCalculator.calculateShortestRoute(8, 4);
        Assertions.assertEquals(20, shortestRoute);
    }

    @Test
    public void calculateShortestRoute_Route6To7_ReturnsShortestRouteLength() {
        int shortestRoute = shortestRouteCalculator.calculateShortestRoute(6, 7);
        Assertions.assertEquals(11, shortestRoute);
    }

    @Test
    public void calculateShortestRoute_Route1To1_ReturnsShortestRouteLength() {
        int shortestRoute = shortestRouteCalculator.calculateShortestRoute(1, 1);
        Assertions.assertEquals(27, shortestRoute);
    }


}
