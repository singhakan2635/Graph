package LeetCodeQuestions;

import java.util.*;

public class CourseScheduler
{
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0;i<prerequisites.length;i++)
        {
            if (!map.containsKey(prerequisites[i][0]))
            {
                map.put(prerequisites[i][0],new LinkedList<>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[numCourses];
        for (Map.Entry<Integer,List<Integer>> entry: map.entrySet())
        {
            for (int n : entry.getValue())
            {
                indegree[n]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<numCourses;i++)
        {
            if (indegree[i]==0)
                queue.offer(i);
        }
        int count =0;
        while (!queue.isEmpty())
        {
            int node = queue.poll();
            count++;
            if (map.containsKey(node))
            {
                for (int each : map.get(node))
                {
                    indegree[each]--;
                    if (indegree[each]==0)
                        queue.offer(each);
                }
            }
        }
        return count==numCourses?true:false;

    }
}
