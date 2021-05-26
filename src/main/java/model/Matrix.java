package model;

/**
 * Matrix representation of the given graph
 */
public class Matrix {

    public int[][] data;
    public int size;

    public Matrix(int[][] data) {
        this.data = data;
        this.size = data.length;
    }

    public Matrix(int size, RouteList routeList) {
        this.size = size;
        data = new int[size][size];

        for (Route route: routeList.getRoutes()) {
            data[route.from.id][route.to.id] = route.distance;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < size; i++) {
            s.append(i).append(": ");
            for (int j = 0; j < size; j++) {
                s.append(data[i][j]).append(" ");
            }
            s.append("\n");
        }

        return s.toString();
    }
}
