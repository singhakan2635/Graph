package GraphBuilder;

public class MainClass
{
    public static void main(String[] args)
    {
        int[][] arr = new int[][]{{0,1},{0,12},{1, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {5, 9},
                {5, 10}, {4, 7}, {4, 8}, {7, 11}, {7, 12}};
        int[][] arr1 = new int[][]{{0,1},{0,2},{0,3},{1,4},{1,5},{2,6},{2,7},{3,8}};

        int[][] arr2 = new int[][]{{5,2},{5,0},{4,0},{4,1},{2,3},{3,1}};
        GraphTraversal dfs = new GraphTraversal();
        dfs.BuildGraph(arr);

        dfs.TraversalDFSRec();
        System.out.println();
        dfs.TraversalBFS();

        DetectCycle detectCycle = new DetectCycle();
        detectCycle.BuildGraph(arr1);
        System.out.println("Cycle is "+detectCycle.detectCycle());

        BipartiteGraph bipartiteGraph = new BipartiteGraph();
        System.out.println("Graph is Bipartite - "+bipartiteGraph.bipartiteGraph(arr1,0));

        TopologicalSort sort = new TopologicalSort();
        System.out.println("Topological Order - ");
        sort.TopologicalSorting(arr1);

        TopologicalSortingBasedOnKahnAlgo kahnAlgo =new TopologicalSortingBasedOnKahnAlgo();
        System.out.println("Topological Sorting USing Kahn's Algo - ");
        kahnAlgo.topologicalSort(arr2);


    }
}
