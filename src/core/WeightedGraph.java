package core;

import java.util.*;

public class WeightedGraph<VertexType> {
    private final boolean undirected;
    private Map<VertexType, Vertex<VertexType>> vertices = new HashMap<>();

    public WeightedGraph() {
        this.undirected = true;
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public boolean containsVertex(VertexType key) {
        return vertices.containsKey(key);
    }

    public void addVertex(VertexType key) {
        vertices.put(key, new Vertex<>(key));
    }

    public Vertex<VertexType> getVertex(VertexType key) {
        return vertices.get(key);
    }

    public Set<VertexType> getVertices() {
        return vertices.keySet();
    }

    public void addEdge(VertexType sourceKey, VertexType destKey, double weight) {
        if (!containsVertex(sourceKey))
            addVertex(sourceKey);

        if (!containsVertex(destKey))
            addVertex(destKey);

        if (sourceKey.equals(destKey))
            return;

        Vertex<VertexType> source = getVertex(sourceKey);
        Vertex<VertexType> dest = getVertex(destKey);

        if (source.getAdjacentVertices().containsKey(dest))
            return;

        source.addAdjacentVertex(dest, weight);
        if (undirected)
            dest.addAdjacentVertex(source, weight);
    }
}
