package LeetCodeQuestions;

import java.util.*;

public class CourseScheduler2
{
        public int[] findOrder(int numCourses, int[][] prerequisites)
        {
            List<Integer> result = new ArrayList<>();
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i=0;i< prerequisites.length;i++)
            {
                if (!map.containsKey(prerequisites[i][1]))
                {
                    map.put(prerequisites[i][1],new LinkedList<>());
                }
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
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
            while (!queue.isEmpty())
            {
                int node = queue.poll();
                result.add(node);
                if (map.containsKey(node))
                {
                    for (int each : map.get(node))
                    {
                        indegree[each]--;
                        if (indegree[each]==0)
                        {
                            queue.offer(each);
                        }
                    }
                }
            }
            if (result.size()!=numCourses)
                return new int[]{};
            int[] res = new int[result.size()];
            for (int i=0;i<result.size();i++)
            {
                res[i] = result.get(i);
            }
            return res;

        }
}
