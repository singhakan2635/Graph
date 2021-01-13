package GraphBuilder;

public class MainClass
{
    public static void main(String[] args)
    {
        int[][] arr = new int[][]{{0,1},{0,12},{1, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {5, 9},
                {5, 10}, {4, 7}, {4, 8}, {7, 11}, {7, 12}};
        GraphTraversal dfs = new GraphTraversal();
        dfs.BuildGraph(arr);

        dfs.TraversalDFSRec();
        System.out.println();
        dfs.TraversalBFS();


    }
}
