package GraphBuilder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal
{
    GraphBuilder graph;
    public void BuildGraph(int[][] arr)
    {
        this.graph = new GraphBuilder();
        for (int i=0;i< arr.length;i++)
        {
            graph.addEdge(arr[i][0],arr[i][1]);
        }
        graph.printGraph();
    }
    public void TraversalDFSRec()
    {
        int n = graph.getSize();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        helper(visited,0);
    }
    private void helper(boolean[] visited, int node)
    {
        if (visited[node])
            return;
        visited[node] = true;
        System.out.print(node + " ");
        for (int i=0;i<graph.mapInt.get(node).size();i++)
        {
            int k = graph.getEdge(node,i);
            if (!visited[k])
                helper(visited,k);
        }
    }

    public void TraversalBFS()
    {
        int n = graph.getSize();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i=0;i<size;i++)
            {
                int node = queue.poll();
                System.out.print(node +" ");
                for (int j=0;j<graph.mapInt.get(node).size();j++)
                {
                    int k = graph.getEdge(node,j);
                    if (!visited[k])
                    {
                        queue.offer(k);
                        visited[k] =true;
                    }
                }
            }
        }
    }

}
