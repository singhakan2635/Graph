package GraphBuilder;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class CreateGraph
{
    public HashMap buildGraph(int[][] arr)
    {
        HashMap<Integer, List<Integer>> map =new LinkedHashMap<>();
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
        return map;
    }
}
