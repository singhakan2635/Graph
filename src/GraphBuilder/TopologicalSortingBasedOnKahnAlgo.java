package GraphBuilder;

import java.util.*;

public class TopologicalSortingBasedOnKahnAlgo
{
    HashMap<Integer, List<Integer>> map;
    public void topologicalSort(int[][] arr)
    {
        CreateGraph2 graph = new CreateGraph2();
        map = graph.buildGraph(arr);
        graph.printGraph(map);
        int n = graph.getSize();
        //int n = 6;
        int[] inorder = new int[n];
        for (Map.Entry<Integer,List<Integer>> entry: map.entrySet())
        {
            List<Integer> temp = entry.getValue();
            for (int node:temp)
            {
                inorder[node]++;
            }
        }
        System.out.println("Inorder "+Arrays.toString(inorder));

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<n;i++)
        {
            if (inorder[i]==0)
                queue.offer(i);
        }
        List<Integer> L =new ArrayList<>();
        while (!queue.isEmpty())
        {
            int vertex = queue.poll();
            L.add(vertex);
            System.out.println("vertx is "+vertex);
            if (map.containsKey(vertex))
            {
                for (int node: map.get(vertex))
                {
                    if (--inorder[node]==0)
                    {
                        queue.offer(node);
                    }
                }
            }

        }
        System.out.println("L is "+L);
        if (L.size()!=n)
        {
            System.out.println("There is a cycle");
        }
        for (int i:L)
        {
            System.out.print(i+" ");
        }

    }
}
