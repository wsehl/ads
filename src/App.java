import java.util.Iterator;

import core.WeightedGraph;
import search.Search;
import search.BreadthFirstSearch;
import search.DepthFirstSearch;
import search.DijkstraSearch;

public class App {
    public static void outputPath(Search<String> search, String key) {
        Iterator<String> iterator = search.pathTo(key).iterator();

        while (iterator.hasNext()) {
            String v = iterator.next();
            System.out.print(v);
            if (iterator.hasNext()) {
                System.out.print(" -> ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        WeightedGraph<String> graph = new WeightedGraph<>(true);

        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);

        // Dijkstra
        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(graph, "Almaty");
        outputPath(djk, "Kyzylorda");
        System.out.println("\n");

        // BFS
        System.out.println("Breadth First Search:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        outputPath(bfs, "Kyzylorda");
        System.out.println("\n");

        // DFS
        System.out.println("Depth First Search:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        outputPath(dfs, "Kyzylorda");
        System.out.println("\n");
    }
}
