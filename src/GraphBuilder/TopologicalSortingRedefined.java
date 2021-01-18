package GraphBuilder;

import java.util.HashMap;
import java.util.List;

public class TopologicalSortingRedefined
{
    class edge
    {
        int node;
        int arrival;
        int departure;

        public edge(int node, int arrival, int departure) {
            this.node = node;
            this.arrival = arrival;
            this.departure = departure;
        }

        public edge(int node) {
            this.node = node;
        }
    }
    HashMap<Integer, List<Integer>> map;
    public void topological(int[][] arr)
    {
        CreateGraph graph = new CreateGraph();
        map = graph.buildGraph(arr);

    }
}
