package GraphBuilder;

public class DetectCycle
{
    GraphBuilder graph;
    public void BuildGraph(int[][] arr)
    {
        this.graph = new GraphBuilder();
        for (int i=0;i< arr.length;i++)
        {
            graph.addEdge(arr[i][0],arr[i][1]);
        }
        graph.printGraph();
    }

    public boolean detectCycle()
    {
        int n = graph.getSize();
        boolean[] visited = new boolean[n];
        return detectCycle(0,visited,-1);
    }
    private boolean detectCycle(int node, boolean[] visited, int parent)
    {

        visited[node] = true;
        for (int i=0;i<graph.mapInt.get(node).size();i++)
        {
            int k = graph.getEdge(node,i);
            if (!visited[k])
            {
                if (detectCycle(k,visited,node))
                    return true;
            }
            else if (k!=parent && parent!=-1)
                return true;
        }
        return false;
    }
}
