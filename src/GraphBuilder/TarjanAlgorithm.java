package GraphBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class TarjanAlgorithm
{
    HashMap<Integer, List<Integer>> map;
    Stack<Integer> stack;
    boolean[] stackMember;
    int[] desc;
    int[] low;
    int time =0;
    public void StronglyConnectedComponent(int[][] arr)
    {
        CreateGraph2 graph2 = new CreateGraph2();
        map = graph2.buildGraph(arr);
        int n = graph2.getSize();

        stack =new Stack<>();
        stackMember = new boolean[n];
        desc = new int[n];
        low = new int[n];
        for (int i=0;i<n;i++)
        {
            desc[i] =-1;
            low[i] = -1;
        }

        for (int i=0;i<n;i++)
        {
            if (desc[i]==-1)
            {
                dfs(i);
            }

        }
        System.out.println(Arrays.toString(low));
    }
    private void dfs(int v)
    {
        stack.push(v);
        stackMember[v] = true;
        low[v] = time;
        desc[v] = time;
        time++;

        if (map.containsKey(v))
        {
            for (int u : map.get(v))
            {
                if (desc[u]==-1)
                {
                    dfs(u);

                }
                if (stackMember[u])
                {
                    System.out.println("Low - "+Arrays.toString(low));
                    low[v] = Math.min(low[v],low[u]);
                }

            }
        }
        int w=-1;
        System.out.println("Leaving for loop - "+ v);
        if (desc[v]==low[v])
        {
            while (w!=v){
                w = stack.pop();
                System.out.print(w+" ");
                stackMember[w] = false;

            }
            System.out.println();

        }
    }
}
