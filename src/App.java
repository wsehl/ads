import core.WeightedGraph;
import search.Search;
import search.BreadthFirstSearch;
import search.DepthFirstSearch;
import search.DijkstraSearch;

public class App {
    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
    }

    public static void main(String[] args) throws Exception {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);

        weightedGraph.addEdge("Almaty", "Astana", 2.1);
        weightedGraph.addEdge("Almaty", "Shymkent", 7.2);
        weightedGraph.addEdge("Shymkent", "Astana", 3.9);
        weightedGraph.addEdge("Astana", "Kostanay", 3.5);
        weightedGraph.addEdge("Shymkent", "Kyzylorda", 5.4);

        // Dijkstra
        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
        outputPath(djk, "Kyzylorda");
        System.out.println("\n");

        // BFS
        System.out.println("Breadth First Search:");
        Search<String> bfs = new BreadthFirstSearch<>(weightedGraph, "Almaty");
        outputPath(bfs, "Kyzylorda");
        System.out.println("\n");

        // DFS
        System.out.println("Depth First Search:");
        Search<String> dfs = new DepthFirstSearch<>(weightedGraph, "Almaty");
        outputPath(dfs, "Kyzylorda");
        System.out.println("\n");
    }
}
