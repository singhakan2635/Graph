package LeetCodeQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder
{
    public int snakesAndLadders(int[][] board)
    {

        int n = board.length;
        if (n==0) return 0;
        int k=1;
        int totalSqaure = n*n;
        int[] newBoard = new int[totalSqaure+1];
        boolean left2Right = true;

        for (int i=n-1;i>=0;i--)
        {
            if (left2Right)
            {
                for (int j=0;j<n;j++)
                {
                    newBoard[k++] = board[i][j];
                }
            }
            else
            {
                for (int j = n-1;j>=0;j--)
                {
                    newBoard[k++] = board[i][j];
                }
            }
            left2Right = !left2Right;

        }
        Queue<Var> queue = new LinkedList<>();
        Var var = new Var(1,0);
        boolean[] visited = new boolean[totalSqaure+1];
        Arrays.fill(visited,false);
        visited[1] = true;

        while (!queue.isEmpty())
        {
            var = queue.poll();
            int node = var.vertex;

            if (node==totalSqaure)
                break;

            for (int j=node+1;j<=node+6 && j<=totalSqaure;j++)
            {
                if (!visited[j])
                {
                    Var temp = new Var();
                    temp.move = var.move+1;
                    visited[j] = true;

                    if (newBoard[j]!=-1)
                    {
                        temp.vertex = newBoard[j];
                    }
                    else
                    {
                        temp.vertex = j;
                    }
                    queue.add(temp);

                }

            }
        }
        if (var.vertex!=totalSqaure)
            return -1;
        return var.move;


    }

    class Var
    {
        int vertex;
        int move;

        public Var(int vertex, int move) {
            this.vertex = vertex;
            this.move = move;
        }

        public Var() {
        }
    }

}
