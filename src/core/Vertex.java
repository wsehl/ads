package core;

import java.util.Map;
import java.util.HashMap;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public void addAdjacentVertex(Vertex<V> destination, Double weight) {
        adjacentVertices.put(destination, weight);
    }

    public void removeAdjacentVertex(Vertex<V> destination) {
        adjacentVertices.remove(destination);
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
}
