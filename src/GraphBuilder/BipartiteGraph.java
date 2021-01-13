package GraphBuilder;

import java.util.*;

public class BipartiteGraph
{
    public boolean bipartiteGraph(int[][] arr,int node)
    {
        CreateGraph graph = new CreateGraph();
        HashMap<Integer, List<Integer>> adlist = graph.buildGraph(arr);
        Queue<Integer> queue = new LinkedList<>();
        int n = adlist.size();
        boolean[] visited = new boolean[n];
        int[] level = new int[n];

        queue.offer(node);
        visited[node] = true;
        level[node] = 0;

        while (!queue.isEmpty())
        {
            int v = queue.poll();

            for (int k : adlist.get(v))
            {
                if (!visited[k])
                {
                    queue.offer(k);
                    level[k] = level[v]+1;
                }
                else if (level[k]==level[v])
                    return false;
            }
        }
        return true;


    }
}
