package Grid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheMaze
{
    int N;
    int M;
    boolean[][] visited;
    int[][] maze;

    public boolean hasPath(int[][] maze, int[] start, int[] destination)
    {
        this.maze = maze;
        N = maze.length;
        M = maze[0].length;
        //System.out.println("N is "+N +", M is "+M);
        visited = new boolean[maze.length][maze[0].length];
        return bfs(start[0],start[1],destination);
    }
    private boolean isValid(int x, int y)
    {
        return x>=0 && y>=0 && x< maze.length && y< maze[0].length && maze[x][y]==0;
    }
    private boolean bfs(int srcx, int srcY,int[] destination)
    {
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(srcx,srcY));
        while (!queue.isEmpty())
        {
            Pair pair = queue.poll();
            if (pair.x==destination[0] && pair.y==destination[1])
                return true;
            if (visited[pair.x][pair.y])
                continue;
            visited[pair.x][pair.y]=true;
            for (int[] dir : directions)
            {
                int newx = pair.x;
                int newY = pair.y;
                while (isValid(newx+dir[0],newY+dir[1]))
                {
                    newx +=dir[0];
                    newY +=dir[1];
                }
                //System.out.println("x is "+newx+" , y is "+newY);
                if (!visited[newx][newY])
                {
                    queue.offer(new Pair(newx,newY));
                }
            }
        }
        return false;
    }
    class Pair
    {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
