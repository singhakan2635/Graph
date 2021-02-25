package LeetCodeQuestions;

import java.util.*;

public class AllThePathFromSourceTotarget
{
    public List<List<Integer>> allPathsSourceTarget(int[][] graph)
    {
        List<List<Integer>> result = new ArrayList<>();
        int n= graph.length-1;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(0));
        while (!queue.isEmpty())
        {
            List<Integer> list = queue.poll();
            int vertex = list.get(list.size()-1);
            if (vertex==n)
            {
                result.add(list);
                continue;
            }
            for (int node: graph[vertex])
            {
                List<Integer> next = new ArrayList<>(list);
                next.add(node);
                queue.offer(next);
            }
        }
        return result;
    }
    public List<List<Integer>> allPathsSourceTarget2(int[][] graph)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph,result,0,path);

        return result;
    }

    private void dfs(int[][] graph, List<List<Integer>> result, int node, List<Integer> path)
    {
        if (node== graph.length-1)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int each : graph[node])
        {
            path.add(each);
            dfs(graph,result,each,path);
            path.remove(path.size()-1);
        }
    }

}
