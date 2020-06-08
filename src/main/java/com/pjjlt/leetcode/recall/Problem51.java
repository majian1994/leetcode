package com.pjjlt.leetcode.recall;

import java.util.ArrayList;
import java.util.List;

public class Problem51 {
  public static void main(String[] args) {
    solveNQueens(4);
  }
  // 棋盘，放皇后
  public static int[][] arry;
  // 棋盘大小
  private static int size;
  // 结果
  private static List<List<String>> result = new ArrayList<>();
  // 棋盘大小
  public static List<List<String>> solveNQueens(int n) {
    // 棋盘
    size = n;
    arry = new int[n][n];
    // 数据初始化，有A错一次
    result = new ArrayList<>();
    // 边界条件，A错一次
    if (n == 1) {
      List<String> one = new ArrayList<>();
      one.add("Q");
      result.add(one);
      System.out.println(result);
      return result;
    }
    findQueen(0);
    System.out.println(result);
    return result;
  }
  // 寻找皇后节点
  public static void findQueen(int i) {
    // 八皇后的解
    if (i > size - 1) {
      List<String> list = new ArrayList<>();
      for (int x = 0; x < size; x++) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int y = 0; y < size; y++) {
          if (arry[x][y] == 1) {
            stringBuffer.append("Q");
          } else {
            stringBuffer.append(".");
          }
        }
        list.add(stringBuffer.toString());
      }
      result.add(list);
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
