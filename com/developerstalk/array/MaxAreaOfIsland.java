package com.developerstalk.array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Map<String, Integer> hm = new HashMap<>();
        int ans=0;
        for(int i=0; i<m; i++){
            for(int j=0;j<n; j++){
                System.out.println();
                if(grid[i][j] == 1){
                    ans=Math.max(ans,getMax(grid,i,j,m,n));    
                }
            }
        }
        return ans;
    }

    public static int getMax(int[][] grid, int i,int j, int m, int n){
    	grid[i][j] = 0;

        return IntStream.of(
                isValid(i, j + 1, m, n) && grid[i][j + 1] == 1 ? getMax(grid, i, j + 1, m, n) : 0,
                isValid(i, j - 1, m, n) && grid[i][j - 1] == 1 ? getMax(grid, i, j - 1, m, n) : 0,
                isValid(i + 1, j, m, n) && grid[i + 1][j] == 1 ? getMax(grid, i + 1, j, m, n) : 0,
                isValid(i - 1, j, m, n) && grid[i - 1][j] == 1 ? getMax(grid, i - 1, j, m, n) : 0
        ).sum() + 1;
    }


    public static boolean isValid(int i,int j, int m, int n){
    	return i >= 0 && i < m && j >= 0 && j < n;    
    }
}
