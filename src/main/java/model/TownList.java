package model;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static util.ErrorConstants.INDEX_OUT_OF_BOUNDS_ERROR;

public class TownList {

    private final ArrayList<Town> towns = new ArrayList<>();

    public void addTown(Town town) {
        int index = towns.size();
        if (!towns.contains(town)) {
            town.id = index;
            towns.add(town);
        }
    }

    public int getNumTowns() {
        return towns.size();
    }

    public Town getTownByName(String townName) {
        return towns.stream()
                .filter(town -> town.name.equals(townName))
                .collect(Collectors.toList()).get(0);
    }

    /**
     * Given an array of town names, return an array of town identifiers
     * corresponding to each name
     * @param townNames a list of town names
     * @return a list of town ids
     */
    public ArrayList<Integer> mapTownNamesToIds(ArrayList<String> townNames) throws Exception {
        ArrayList<Integer> townIds = new ArrayList<>();
        try {
            for (String townName: townNames) {
                Town town = this.getTownByName(townName);
                townIds.add(town.id);
            }
            return townIds;
        } catch (IndexOutOfBoundsException e) {
            throw new Exception(INDEX_OUT_OF_BOUNDS_ERROR);
        }
    }

    @Override
    public String toString(){
        return towns.toString();
    }
}
