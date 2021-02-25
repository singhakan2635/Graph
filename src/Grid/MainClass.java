package Grid;

public class MainClass
{
    public static void main(String[] args)
    {
        int[][] arr = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0,4};
        int[] destination = new int[]{4,4};

        TheMaze maze= new TheMaze();
        System.out.println(maze.hasPath(arr,start,destination));

        NumberOfProvinces provinces = new NumberOfProvinces();
        int[][] arr1 = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(provinces.findCircleNum(arr1));

    }
}
