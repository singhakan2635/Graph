package GraphBuilder;

import java.util.*;

public class GraphComplete
{
    public static void main(String[] args)
    {
        int[][] arr1 = new int[][]{{0,1},{0,2},{0,3},{1,4},{1,5},{2,6},{2,7},{3,8}};
        GraphComplete graph = new GraphComplete();
        graph.buildGraph(arr1);
        graph.printMap();
        graph.TraversalBFS();
    }

    HashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
    private void buildGraph(int[][] arr)
    {
        for (int i=0;i<arr.length;i++)
        {
            if (!map.containsKey(arr[i][0]))
            {
                map.put(arr[i][0],new LinkedList<>());
            }
            if (!map.containsKey(arr[i][1]))
            {
                map.put(arr[i][1],new LinkedList<>());
            }
            map.get(arr[i][0]).add(arr[i][1]);
            map.get(arr[i][1]).add(arr[i][0]);
        }
    }
    private void printMap()
    {
        for (Map.Entry<Integer,List<Integer>> entry: map.entrySet())
        {
            System.out.println("Node "+entry.getKey() +" -> "+entry.getValue());
        }
    }

    private void TraversalBFS()
    {
        boolean[] visited = new boolean[map.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i=0;i<size;i++)
            {
                int n = queue.poll();
                System.out.print(n+" ");
                for (int k : map.get(n))
                {
                    if (!visited[k])
                    {
                        queue.offer(k);
                        visited[k] = true;
                    }

                }
            }
        }

    }

}
