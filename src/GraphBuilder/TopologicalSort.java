package GraphBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TopologicalSort
{
    int[] arrival;
    int[] departure;
    boolean[] visited;
    int time=-1;
    int[] dfsOrder;
    int index=0;
    HashMap<Integer,List<Integer>> adlist;
    public void TopologicalSorting(int[][] arr)
    {
        CreateGraph graph = new CreateGraph();
        graph.buildGraph(arr);
        adlist = graph.buildGraph(arr);
        int n = adlist.size();
        arrival = new int[n];
        departure = new int[n];
        dfsOrder = new int[n];
        visited = new boolean[n];
        for (int i=0;i<n;i++)
        {
            if (!visited[i])
                dfs(0);
        }
        System.out.println("DFS - "+ Arrays.toString(dfsOrder));
        System.out.println("Arrival - "+Arrays.toString(arrival));
        System.out.println("Departure - "+Arrays.toString(departure));


    }
    private void dfs(int node)
    {
        arrival[node] = ++time;
        visited[node] = true;
        for (int i=0;i<adlist.get(node).size();i++)
        {
            int k = adlist.get(node).get(i);
            if (!visited[k])
            {
                dfs(k);
            }
        }
        dfsOrder[index++] = node;
        departure[node] = ++time;
        return;

    }
}
