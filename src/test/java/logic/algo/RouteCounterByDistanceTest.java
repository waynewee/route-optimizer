package logic.algo;

import model.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RouteCounterByDistanceTest {

    private static RouteCounterByDistance routeCounterByDistance;
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
        routeCounterByDistance = new RouteCounterByDistance(matrix);
    }

    @Test
    public void countRoutes_0To10Distance20_ReturnsNumRoutes() {
        int numRoutes = routeCounterByDistance.countRoutes(0, 10, 20);
        Assertions.assertEquals(4, numRoutes);
    }

    @Test
    public void countRoutes_4To6Distance30_ReturnsNumRoutes() {
        int numRoutes = routeCounterByDistance.countRoutes(4, 6, 30);
        Assertions.assertEquals(2, numRoutes);
    }

    @Test
    public void countRoutes_2To2Distance20_ReturnsNumRoutes() {
        int numRoutes = routeCounterByDistance.countRoutes(2, 2, 20);
        Assertions.assertEquals(3, numRoutes);
    }

    @Test
    public void countRoutes_0To9Distance0_ReturnsZero() {
        int numRoutes = routeCounterByDistance.countRoutes(0, 9, 0);
        Assertions.assertEquals(0, numRoutes);
    }

}
