package com.pjjlt.leetcode.recall;

import java.util.ArrayList;
import java.util.List;

public class Problem52 {
  public static void main(String[] args) {
    int result = totalNQueens(1);
    System.out.println(result);
  }
  // 棋盘，放皇后
  public static int[][] arry;
  // 棋盘大小
  private static int size;
  // 结果
  private static int count = 0;
  // 棋盘大小
  public static int totalNQueens(int n) {
    // 棋盘
    size = n;
    arry = new int[n][n];
    count = 0;
    // 边界条件
    if (n == 1) {
      return 1;
    }
    findQueen(0);
    return count;
  }
  // 寻找皇后节点
  public static void findQueen(int i) {
    // 八皇后的解
    if (i > size - 1) {
      count++;
      return;
    }
    // 深度回溯,递归算法
    for (int m = 0; m < size; m++) {
      // 检查皇后摆放是否合适
      if (check(i, m)) {
        arry[i][m] = 1;
        findQueen(i + 1);
        // 清零，以免回溯的时候出现脏数据
        arry[i][m] = 0;
      }
    }
  }
  // 判断节点是否合适
  public static boolean check(int k, int j) {
    // 检查列冲突
    for (int i = 0; i < size; i++) {
      if (arry[i][j] == 1) {
        return false;
      }
    }
    // 检查左对角线
    for (int i = k - 1, m = j - 1; i >= 0 && m >= 0; i--, m--) {
      if (arry[i][m] == 1) {
        return false;
      }
    }
    // 检查右对角线
    for (int i = k - 1, m = j + 1; i >= 0 && m < size; i--, m++) {
      if (arry[i][m] == 1) {
        return false;
      }
    }
    return true;
  }
}
