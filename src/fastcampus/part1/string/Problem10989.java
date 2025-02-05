package fastcampus.part1.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수 정렬하기3
 * <p/>
 * https://www.acmicpc.net/problem/10989
 */
public class Problem10989 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] numArr = new int[10001];
    for (int i = 0; i < N; i++) {
      int idx = Integer.parseInt(br.readLine());
      numArr[idx]++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= 10000; i++) {
      while (numArr[i] > 0) {
        sb.append(i).append("\n");
        numArr[i]--;
      }
    }

    System.out.print(sb);
  }
}

/*
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] numArr = new int[10001];
    for (int i = 0; i < N; i++) {
      int idx = Integer.parseInt(br.readLine());
      numArr[idx]++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= 10000; i++) {
      while (numArr[i] > 0) {
        sb.append(i).append("\n");
        numArr[i]--;
      }
    }

    System.out.print(sb);
  }
}
*/
