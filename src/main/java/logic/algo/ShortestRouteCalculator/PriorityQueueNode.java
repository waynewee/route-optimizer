package logic.algo.ShortestRouteCalculator;

class PriorityQueueNode implements Comparable<PriorityQueueNode> {

    public int id;
    public int distance;

    public PriorityQueueNode(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    @Override
    public int compareTo(PriorityQueueNode node) {
        return Integer.compare(this.distance, node.distance);
    }
}
