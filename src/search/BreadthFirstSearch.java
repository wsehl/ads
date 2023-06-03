package search;

import java.util.*;

import core.Vertex;
import core.WeightedGraph;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, V source) {
        Queue<V> queue = new LinkedList<>();
        queue.offer(source);
        marked.add(source);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            for (Vertex<V> vertex : graph.getVertex(current).getAdjacentVertices().keySet()) {
                V adjacentVertexData = vertex.getData();
                if (!marked.contains(adjacentVertexData)) {
                    edgeTo.put(adjacentVertexData, current);
                    marked.add(adjacentVertexData);
                    queue.offer(adjacentVertexData);
                }
            }
            count++;
        }
    }
}
