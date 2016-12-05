package puzzles.cracking.hackerrank.algorithms;

import java.util.Scanner;

public class DFS {
	   
    public static int getBiggestRegion(int[][] matrix) {
        
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        int max = 0;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1 && !visited[i][j])
                    max = Math.max(max, regionSize(matrix, visited, i, j));
            }
        }
        
        return max;
    }
    
    static int regionSize(int[][] matrix, boolean[][] visited, int y, int x){
        visited[y][x] = true;
        int size = 1;
        int W = x - 1;
        int E = x + 1;
        int N = y - 1;
        int S = y + 1;
        boolean wOk = W >= 0;
        boolean eOk = E < matrix[0].length;
        boolean nOk = N >= 0;
        boolean sOk = S < matrix.length;
        
        
        //cardinals
        if( wOk   && matrix[y][W] == 1    && !visited[y][W])
            size += regionSize(matrix, visited, y, W);
        if( eOk   && matrix[y][E] == 1    && !visited[y][E])
            size += regionSize(matrix, visited, y, E);
        if( nOk   && matrix[N][x] == 1    && !visited[N][x])
            size += regionSize(matrix, visited, N, x);
        if( sOk   && matrix[S][x] == 1    && !visited[S][x])
            size += regionSize(matrix, visited, S, x);
        
        //diagonals
        if( wOk && nOk   && matrix[N][W] == 1    && !visited[N][W])
            size += regionSize(matrix, visited, N, W);
        if( eOk && nOk   && matrix[N][E] == 1    && !visited[N][E])
            size += regionSize(matrix, visited, N, E);
        if( wOk && sOk   && matrix[S][W] == 1    && !visited[S][W])
            size += regionSize(matrix, visited, S, W);
        if( eOk && sOk   && matrix[S][E] == 1    && !visited[S][E])
            size += regionSize(matrix, visited, S, E);
        
        return size;
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
        in.close();
    }
}
