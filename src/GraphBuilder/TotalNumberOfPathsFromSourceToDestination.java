package GraphBuilder;

import java.util.*;

public class TotalNumberOfPathsFromSourceToDestination
{
    public int TotalNumberOFPaths(int src, int dest, int m, int[][] arr)
    {
        CreateGraph2 graph = new CreateGraph2();
        HashMap<Integer,List<Integer>> map = graph.buildGraph(arr);
        List<String> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(src,0,""+src));

        int count=0;

        while (!queue.isEmpty())
        {
            Node node = queue.poll();
            int vertex = node.vertex;
            int depth = node.depth;

            if (vertex==dest && depth==m)
            {
                count++;
                result.add(node.path);
            }
            if (depth>m)
                break;

            if (map.containsKey(vertex))
            {
                for (int each : map.get(vertex))
                {
                    queue.add(new Node(each,depth+1,node.path+" -> "+each));
                }
            }
        }
        System.out.println(result);

    return count;
    }
    class Node
    {
        int vertex;
        int depth;
        String path;

        public Node(int vertex, int depth,String path) {
            this.vertex = vertex;
            this.depth = depth;
            this.path = path;
        }
    }
}
