package logic.algo.ShortestRouteCalculator;

import model.Matrix;

import java.util.*;

/**
 * Calculates the shortest route between two points.
 * Provides cache for previously computed results
 */
public class ShortestRouteCalculator {

    private final Matrix matrix;
    private final HashMap<Integer, int[]> cache;

    private int[][] m;
    private int[] distances;
    private Set<Integer> visited;
    private PriorityQueue<PriorityQueueNode> priorityQueue;

    public ShortestRouteCalculator(Matrix matrix){
        this.matrix = matrix;
        cache = new HashMap<>();
    }

    /**
     * Returns the shortest route between two towns
     * @param u index of start town
     * @param v index of end town
     * @return distance of the shortest route between u and v
     */
    public int calculateShortestRoute(int u, int v) {

        if(cache.containsKey(u)){
            return cache.get(u)[v];
        }

        visited = new HashSet<>();
        priorityQueue = new PriorityQueue<>();

        int start = u;
        int end = v;

        if (start != end) {
            m = matrix.data;
        } else {
            start = matrix.size;
            end = matrix.size + 1;
            m = new int[matrix.size + 2][matrix.size + 2];
            for (int i = 0; i < matrix.size; i++) {
                System.arraycopy(matrix.data[i], 0, m[i], 0, matrix.size);
            }
            System.arraycopy(matrix.data[u], 0, m[start], 0, matrix.size);

            for (int i = 0; i < matrix.size; i++) {
                m[i][end] = matrix.data[i][u];
            }
        }

        distances = new int[m.length];
        djikstra(start);
        cache.put(start, distances);
        return distances[end];
    }

    /**
     * Implementation for Djikstra's shortest paths
     * Computes shortest path from u to every node in graph
     * @param u index of start town
     */
    private void djikstra(int u) {

        for (int i = 0; i < m.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        priorityQueue.add(new PriorityQueueNode(u, 0));
        distances[u] = 0;

        while (visited.size() != m.length && priorityQueue.size() > 0) {
            int curr = priorityQueue.remove().id;
            visited.add(curr);
            processAdjacentNodes(curr);
        }

    }

    private void processAdjacentNodes(int curr) {
        int d;
        int newD;

        int[] l = m[curr];
        for (int i = 0; i < l.length; i++) {
            if(l[i] > 0 && !visited.contains(i)) {
                d = l[i];
                newD = distances[curr] + d;
                if (newD < distances[i]) {
                    distances[i] = newD;
                }
                priorityQueue.add(new PriorityQueueNode(i, distances[i]));
            }
        }
    }

}

