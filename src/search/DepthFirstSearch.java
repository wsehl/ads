package search;

import core.Vertex;
import core.WeightedGraph;

public class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(WeightedGraph<V> graph, V source) {
        marked.add(source);
        count++;

        for (Vertex<V> vertex : graph.getVertex(source).getAdjacentVertices().keySet()) {
            V adjacentVertexData = vertex.getData();
            if (!marked.contains(adjacentVertexData)) {
                edgeTo.put(adjacentVertexData, source);
                dfs(graph, adjacentVertexData);
            }
        }
    }
}
