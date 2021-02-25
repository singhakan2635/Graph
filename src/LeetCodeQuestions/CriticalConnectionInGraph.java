package LeetCodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CriticalConnectionInGraph
{
    List<List<Integer>> res = new ArrayList<>();

    HashMap<Integer,List<Integer>> map;
    int[] disc;
    int[] low;
    int time=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections)
    {
        map = new HashMap<>();
        for (int i=0;i<connections.size();i++)
        {
            int from = connections.get(i).get(0);
            int to = connections.get(i).get(1);
            if (!map.containsKey(from))
                map.put(from,new ArrayList<>());
            if (!map.containsKey(to))
                map.put(to,new ArrayList<>());
            map.get(from).add(to);
            map.get(to).add(from);
        }
        disc = new int[n];
        low = new int[n];
        for (int i=0;i<n;i++)
        {
            disc[i] =-1;
            low[i] = -1;
        }
        for (int i=0;i<n;i++)
        {
            if (disc[i]==-1)
                dfs(i,res,i);
        }
        return res;

    }
    private void dfs(int v, List<List<Integer>> res,int parent)
    {
        disc[v] = low[v] = time++;

        if (map.containsKey(v))
        {
            for (int each : map.get(v))
            {
                if (each==parent) continue;
                if (disc[each]==-1) {
                    dfs(each, res, v);
                }
                low[v] = Math.min(low[v],low[each]);
                if (low[each]>disc[v])
                {
                    res.add(Arrays.asList(v,each));
                }
            }
        }
    }

}
