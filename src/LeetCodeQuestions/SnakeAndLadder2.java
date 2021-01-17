package LeetCodeQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder2
{
    public int snakesAndLadders(int[][] board)
    {
        int N = board.length;
        int total = N*N;
        if (N==0)
            return 0;

        int[] nBoard = new int[total+1];
        boolean left2right = true;
        int k=0;
        for (int i= N-1;i>=0;i--)
        {
            if (left2right)
            {
                for (int j=0;j<N;j++)
                {
                    nBoard[k++] = board[i][j];
                }
            }
            else
            {
                for (int j =N-1;j>=0;j++)
                {
                    nBoard[k++] = board[i][j];
                }
            }
            left2right = !left2right;
        }

        boolean[] visited = new boolean[total+1];
        Queue<Var> queue = new LinkedList<>();
        Var var = new Var(1,0);
        queue.offer(var);


        while (!queue.isEmpty())
        {
            var = queue.poll();
            int vertex = var.vertex;

            if (vertex==total)
                break;

            for (int i=vertex+1;i<=vertex+6;i++)
            {
                if (!visited[i])
                {
                    Var temp =new Var();
                    temp.move = var.move+1;
                    visited[i] = true;

                    if (nBoard[i]!=-1)
                    {
                        temp.vertex = nBoard[i];
                    }
                    else
                    {
                        temp.vertex = i;
                    }
                    queue.offer(temp);
                }
            }

        }

        if (var.vertex!=total)
            return -1;
        return var.move;
    }

    class Var
    {
        int vertex;
        int move;

        public Var() {
        }

        public Var(int vertex, int move) {
            this.vertex = vertex;
            this.move = move;
        }
    }
}
