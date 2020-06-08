package com.pjjlt.leetcode.dynamic;

public class Problem63 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    // 起始位置就有障碍物的话
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    // 横纵坐标是否有障碍物
    boolean xBarrier = false;
    boolean yBarrier = false;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) {
          if (obstacleGrid[i][j] == 1 && !xBarrier) {
            xBarrier = true;
          }
          if (xBarrier) {
            dp[i][j] = 0;
          } else {
            dp[i][j] = 1;
          }
        } else if (j == 0) {
          if (obstacleGrid[i][j] == 1 && !yBarrier) {
            yBarrier = true;
          }
          if (yBarrier) {
            dp[i][j] = 0;
          } else {
            dp[i][j] = 1;
          }
        } else {
          if (obstacleGrid[i][j] == 1) {
            dp[i][j] = 0;
          } else {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
          }
        }
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    //
  }
}
