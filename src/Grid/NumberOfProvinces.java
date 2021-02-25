package Grid;

public class NumberOfProvinces
{
    public int findCircleNum(int[][] M)
    {
        int n = M.length;
        int m = M[0].length;
        int cnt =0;
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                if (M[i][j]==1 && !visited[i][j])
                {
                    cnt++;
                    dfs(i,j,visited,directions,M);
                }
            }
        }
        return cnt;
    }
    private void dfs(int x,int y,boolean[][] visited,int[][] direction,int[][] M)
    {
        visited[x][y]=true;
        for (int[] dir: direction)
        {
            if (isValid(x+dir[0],y+dir[1],M) && !visited[x+dir[0]][y+dir[1]])
            {
                dfs(x+dir[0],y+dir[1],visited,direction,M);
            }
        }

    }
    private boolean isValid(int x,int y,int[][] M)
    {
        return x>=0 && y>=0 && x<M.length && y<M[0].length && M[x][y]==1;
    }

    public int findCircleNum2(int[][] M)
    {
        int[] visited = new int[M.length];
        int count =0;
        for (int i=0;i<M.length;i++)
        {
            if (visited[i]==0)
            {
                dfs1(M,visited, i);
                count++;
            }
        }
        return  count;
    }
    private void dfs1(int[][] M, int[] visited,int i)
    {
        for (int j=0;j<M.length;j++)
        {
            if (M[i][j]==1 && visited[j]==0)
            {
                visited[j]=1;
                dfs1(M,visited,j);
            }
        }
    }
}
