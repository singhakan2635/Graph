package GraphBuilder;

import java.util.*;

public class CreateGraph2
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
            /*
            if (!map.containsKey(arr[i][1]))
            {
                map.put(arr[i][1],new LinkedList<>());
            }

             */
            map.get(arr[i][0]).add(arr[i][1]);
            //map.get(arr[i][1]).add(arr[i][0]);
        }
        return map;
    }
    public void printGraph(HashMap<Integer,List<Integer>> map)
    {
        for (Map.Entry<Integer,List<Integer>> entry:map.entrySet())
        {
            System.out.println("Node "+ entry.getKey() +" -> "+entry.getValue());

        }
    }
}
