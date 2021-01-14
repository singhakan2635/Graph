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
                    visited[k] = true;
                    level[k] = level[v]+1;
                }
                else if (level[k]==level[v])
                    return false;
            }
        }
        return true;


    }

    public boolean biPartiteGraph2(int[][] graph)
    {
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(visited,false);
        int[] level = new int[graph.length];

        for (int i=0;i< graph.length;i++)
        {
            if (graph[i].length!=0 && !visited[i])
            {
                visited[i] = true;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                level[i] = 1;
                while (!queue.isEmpty())
                {
                    int k = queue.poll();
                    for (int n: graph[k])
                    {
                        if (!visited[n])
                        {
                            visited[n] =true;
                            queue.offer(n);
                            level[n] = level[k]+1;
                        }
                        else if (level[n]==level[k])
                            return false;
                    }
                }

            }
        }
        return true;


    }

    private boolean bipartiteOriginal(int[][] graph)
    {
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(visited,false);
        int[] level = new int[graph.length];

        for (int i=0;i< graph.length;i++)
        {
            if (graph[i].length!=0 && !visited[i])
            {
                visited[i] = true;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                level[i] = 1;
                while (!queue.isEmpty())
                {
                    int k = queue.poll();
                    for (int n: graph[k])
                    {
                        if (!visited[n])
                        {
                            visited[n] =true;
                            queue.offer(n);
                            level[n] = level[k]+1;
                        }
                        else if (level[n]==level[k])
                            return false;
                    }
                }

            }
        }
        return true;
    }
}
