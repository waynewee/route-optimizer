package logic.algo;

import model.Matrix;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;

import static util.ErrorConstants.NO_SUCH_ROUTE_ERROR;

public class DistanceCalculatorTest {

    private static DistanceCalculator distanceCalculator;
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
        distanceCalculator = new DistanceCalculator(matrix);
    }

    @Test
    public void calculateDistance_VisitMultiple_ReturnsDistance() throws Exception {
        ArrayList<Integer> townIds = new ArrayList<>(Arrays.asList(0, 1, 2, 7, 2, 8, 9, 6, 4));
        int distance = distanceCalculator.calculateDistance(townIds);
        Assertions.assertEquals(4 + 1 + 4 + 4 + 7 + 3 + 12 + 5, distance);
    }

    @Test
    public void calculateDistance_InvalidRoute_ReturnsInvalidMessage() {
        ArrayList<Integer> townIds = new ArrayList<>(Arrays.asList(0, 1, 2, 5, 2, 8, 9, 6, 4));
        Exception exception = Assertions.assertThrows(Exception.class, ()-> {
            distanceCalculator.calculateDistance(townIds);
        });
        Assertions.assertEquals(NO_SUCH_ROUTE_ERROR, exception.getMessage());
    }

}
