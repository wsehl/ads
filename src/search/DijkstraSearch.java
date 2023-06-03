package search;

import java.util.*;

import core.Vertex;
import core.WeightedGraph;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<V, Double> distTo;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        distTo = new HashMap<>();
        for (V v : graph.getVertices()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);

        PriorityQueue<V> pq = new PriorityQueue<>(Comparator.comparing(distTo::get));
        pq.offer(source);

        while (!pq.isEmpty()) {
            V current = pq.poll();
            Vertex<V> currentVertex = graph.getVertex(current);

            for (Map.Entry<Vertex<V>, Double> entry : currentVertex.getAdjacentVertices().entrySet()) {
                Vertex<V> adjacentVertex = entry.getKey();
                V adjacentVertexData = adjacentVertex.getData();

                double weight = entry.getValue();

                double currentDist = distTo.get(current) + weight;

                if (currentDist < distTo.get(adjacentVertexData)) {
                    edgeTo.put(adjacentVertexData, current);
                    distTo.put(adjacentVertexData, currentDist);
                    pq.remove(adjacentVertexData);
                    pq.offer(adjacentVertexData);
                    marked.add(adjacentVertexData);
                }
            }
        }
    }
}
