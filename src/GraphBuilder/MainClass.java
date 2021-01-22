package GraphBuilder;

import LeetCodeQuestions.AllThePathFromSourceTotarget;
import LeetCodeQuestions.ReconstructItinery;

import java.util.ArrayList;
import java.util.List;

public class MainClass
{
    public static void main(String[] args)
    {
        int[][] arr = new int[][]{{0,1},{0,12},{1, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {5, 9},
                {5, 10}, {4, 7}, {4, 8}, {7, 11}, {7, 12}};
        int[][] arr1 = new int[][]{{0,1},{0,2},{0,3},{1,4},{1,5},{2,6},{2,7},{3,8}};

        int[][] arr2 = new int[][]{{5,2},{5,0},{4,0},{4,1},{2,3},{3,1}};

        int[][] arr3 = new int[][]{{0,6},{0,1},{1,6},{1,5},{1,2},{2,3},{3,4},{5,2},{5,3},{5,4},{6,5},{7,6},{7,1}};
        int[][] arr4 = new int[][]{{1,2},{3},{3},{}};

        int[][] arr5 = new int[][]{{0,1},{1,2},{2,3},{3,0},{2,4},{4,5},{5,6},{6,4},{7,6},{7,8}};

        List<List<String>> itinery =new ArrayList<>();
        List<String> op = new ArrayList<>();
        op.add("JFK");
        op.add("SFO");
        itinery.add(op);
        List<String> op1 = new ArrayList<>();
        op1.add("JFK");
        op1.add("ATL");
        itinery.add(op1);
        List<String> op2 = new ArrayList<>();
        op2.add("SFO");
        op2.add("ATL");
        itinery.add(op2);
        List<String> op3 = new ArrayList<>();
        op3.add("ATL");
        op3.add("JFK");
        itinery.add(op3);
        List<String> op4 = new ArrayList<>();
        op4.add("ATL");
        op4.add("SFO");
        itinery.add(op4);
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

        TotalNumberOfPathsFromSourceToDestination sourceToDestination = new TotalNumberOfPathsFromSourceToDestination();
        System.out.println("Total numbers of paths - "+ sourceToDestination.TotalNumberOFPaths(0,3,4,arr3));

        AllThePathFromSourceTotarget allpath = new AllThePathFromSourceTotarget();
        System.out.println(allpath.allPathsSourceTarget(arr4));

        System.out.println(itinery);
        ReconstructItinery reconstructItinery = new ReconstructItinery();
        System.out.println(reconstructItinery.findItinerary(itinery));

        System.out.println("Strongly Connected Graph - Kosarajan's Algorithms");
        StronglyConnectedComponentKosarajusAlgo algo =new StronglyConnectedComponentKosarajusAlgo();
        algo.KosarajusAlgo(arr5);
    }
}
