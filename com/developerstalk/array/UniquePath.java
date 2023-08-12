package com.developerstalk.array;

import java.util.HashMap;
import java.util.Map;

// All testcases pass on leetcode.
public class UniquePath {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLength=obstacleGrid[0].length;
        int columnLength=obstacleGrid.length;
        Map<String,Integer> dp = new HashMap<>();
        return checkIfDestination(obstacleGrid,0,0,rowLength,columnLength,dp);
    }

    private int checkIfDestination(int[][] obstacleGrid,int m, int n, int rl, int cl,Map<String,Integer> dp)  {
        Integer bottomIndexCalculation=0;
        Integer rightIndexCalculation=0;
        if(m>=cl || n>=rl){
            return 0;
        }
        else if(obstacleGrid[m][n] == 1){
            return 0;
        }
        else if(m == cl-1 && n == rl-1){
            return 1;
        }
        else{
            bottomIndexCalculation = dp.containsKey((m+1) +","+ n)?dp.get((m+1) +","+ n):checkIfDestination(obstacleGrid,m+1,n,rl,cl,dp);
            dp.put((m+1) +","+ n,bottomIndexCalculation);
            rightIndexCalculation = dp.containsKey(m+","+(n+1))?dp.get(m+","+(n+1)):checkIfDestination(obstacleGrid,m,n+1,rl,cl,dp);
            dp.put(m +","+(n+1),rightIndexCalculation);
             return bottomIndexCalculation + rightIndexCalculation ;
        }
    }
}