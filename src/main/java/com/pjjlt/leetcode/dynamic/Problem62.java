package com.pjjlt.leetcode.dynamic;

public class Problem62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0&&j==0){
                    // 如果只有一个格子，情况算1种，第一次提交失败就在这里
                    dp[i][j] = 1;
                }else if(i==0){
                    dp[i][j] = 1;
                }else if(j==0){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
