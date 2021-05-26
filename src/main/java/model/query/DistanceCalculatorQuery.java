package model.query;

import logic.algo.DistanceCalculator;
import model.Model;

import java.util.ArrayList;

public class DistanceCalculatorQuery extends Query {

    private final ArrayList<Integer> townIds;

    public DistanceCalculatorQuery(ArrayList<Integer> townIds) {
        queryType = QueryType.DISTANCE_CALC;
        this.townIds = townIds;
    }

    public String execute(Model model) throws Exception {
        DistanceCalculator distanceCalculator = new DistanceCalculator(model.getMatrix());
        int answer = distanceCalculator.calculateDistance(townIds);
        return String.valueOf(answer);
    }

}
