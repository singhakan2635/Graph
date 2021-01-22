package GraphBuilder;

import java.util.*;

public class StronglyConnectedComponentKosarajusAlgo
{
    HashMap<Integer, List<Integer>> map;
    boolean[] visited;
    public void KosarajusAlgo(int[][] arr)
    {
        CreateGraph2 graph2 = new CreateGraph2();
        map = graph2.buildGraph(arr);
        graph2.printGraph(map);
        int n = graph2.getSize();
        //System.out.println(n);
        visited = new boolean[n];
        Arrays.fill(visited,false);
        Stack<Integer> stack =new Stack<>();
        for (int i=0;i<n;i++)
        {
            if (!visited[i])
                dfs(false,i,stack);
        }
        System.out.println(Arrays.toString(visited));
        map = creategraph3(arr);
        Arrays.fill(visited,false);
        System.out.println(Arrays.toString(visited));
        while (!stack.empty())
        {
            int v = stack.pop();
            if (!visited[v])
            {
                dfs(true,v,stack);
            }

        }

    }

    private void dfs(boolean display, int vertex,Stack<Integer> stack)
    {
        visited[vertex] =true;
        if (display)
        {
            System.out.print(vertex +" ");
        }

        if (map.containsKey(vertex))
        {
            for (int n: map.get(vertex)) {
                if (!visited[n]) {
                    if (!display)
                        dfs(false, n, stack);
                    if (display)
                        dfs(true,n,stack);
                }
            }
        }
        if (!display)
            stack.push(vertex);
        if (display)
            System.out.println();
    }

    private HashMap creategraph3(int[][] arr)
    {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int i=0;i<arr.length;i++)
        {
            if (!map.containsKey(arr[i][1]))
            {
                map.put(arr[i][1],new ArrayList<>());
            }
            map.get(arr[i][1]).add(arr[i][0]);
        }
        return map;
    }
}
