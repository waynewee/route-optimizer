package model;

public class Route {

    public Town from;
    public Town to;
    public int distance;

    public Route(Town from, Town to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Route other = (Route) obj;
        return (other.from.equals(from) && other.to.equals(to));
    }

    @Override
    public String toString() {
        return from + "--" + distance + "->" + to;
    }
}
