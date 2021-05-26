package logic.algo;

import logic.algo.ShortestRouteCalculator.ShortestRouteCalculator;
import model.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RouteCounterByStopsTest {

    private static RouteCounterByStops routeCounterByStops;
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
        routeCounterByStops = new RouteCounterByStops(matrix);
    }

    @Test
    public void countRoutes_0To10Stops4_ReturnsNumRoutes() {
        int numRoutes = routeCounterByStops.countStops(0, 10, 4);
        Assertions.assertEquals(5, numRoutes);
    }

    @Test
    public void countRoutes_3To8Stops10_ReturnsNumRoutes() {
        int numRoutes = routeCounterByStops.countStops(3, 8, 10);
        Assertions.assertEquals(200, numRoutes);
    }

    @Test public void countRoutes_4To4Stops4_ReturnsNumRoutes() {
        int numRoutes = routeCounterByStops.countStops(4,4,4);
        Assertions.assertEquals(1, numRoutes);
    }

    @Test public void countExactRoutes_9To2Stops6_ReturnsNumRoutes() {
        int numRoutes = routeCounterByStops.countStops(9,2,6);
        Assertions.assertEquals(16, numRoutes);
    }

}
