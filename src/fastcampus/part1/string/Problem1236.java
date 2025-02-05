package fastcampus.part1.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 성 지키기
 * <p/>
 * https://www.acmicpc.net/problem/1236
 */
public class Problem1236 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] sizeArr = br.readLine().split(" ");

    int N = Integer.parseInt(sizeArr[0]);
    int M = Integer.parseInt(sizeArr[1]);

    int[][] targetArr = new int[N][M];
    for (int i = 0; i < N; i++) {
      String row = br.readLine();
      for (int j = 0; j < row.length(); j++) {
        int target = 0;
        if (row.charAt(j) == 'X') {
          target = 1;
        }
        targetArr[i][j] = target;
      }
    }

    int[] targetNArr = new int[N];
    int[] targetMArr = new int[M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (targetArr[i][j] == 1) {
          targetNArr[i] = 1;
          targetMArr[j] = 1;
        }
      }
    }

    int countN = 0;
    int countM = 0;

    for (int i = 0; i < N; i++) {
      if (targetNArr[i] == 0) {
        countN++;
      }
    }

    for (int i = 0; i < M; i++) {
      if (targetMArr[i] == 0) {
        countM++;
      }
    }

    int count = Math.max(countN, countM);

    System.out.println(count);
  }
}


/*
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] sizeArr = br.readLine().split(" ");

    int N = Integer.parseInt(sizeArr[0]);
    int M = Integer.parseInt(sizeArr[1]);

    int[][] targetArr = new int[N][M];
    for (int i = 0; i < N; i++) {
      String row = br.readLine();
      for (int j = 0; j < row.length(); j++) {
        int target = 0;
        if (row.charAt(j) == 'X') {
          target = 1;
        }
        targetArr[i][j] = target;
      }
    }

    int[] targetNArr = new int[N];
    int[] targetMArr = new int[M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (targetArr[i][j] == 1) {
          targetNArr[i] = 1;
          targetMArr[j] = 1;
        }
      }
    }

    int countN = 0;
    int countM = 0;

    for (int i = 0; i < N; i++) {
      if (targetNArr[i] == 0) {
        countN++;
      }
    }

    for (int i = 0; i < M; i++) {
      if (targetMArr[i] == 0) {
        countM++;
      }
    }

    int count = Math.max(countN, countM);

    System.out.println(count);
  }
}
*/
