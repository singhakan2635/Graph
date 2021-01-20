package LeetCodeQuestions;

import java.util.*;

public class ReconstructItinery
{
    public List<String> findItinerary(List<List<String>> tickets)
    {
        List<String> result = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for (int i =0;i<tickets.size();i++)
        {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            if (!map.containsKey(from))
            {
                map.put(from,new ArrayList<>());
            }
            map.get(from).add(to);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet())
        {
            Collections.sort(entry.getValue());
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("JFK");
        while (!queue.isEmpty())
        {
            String node = queue.poll();
            result.add(node);
            if (map.containsKey(node))
            {
                for (String each : map.get(node))
                {
                    queue.offer(each);
                    map.get(node).remove(each);
                    if (map.containsKey(each))
                        break;
                }
            }
        }
        return result;

    }
}
