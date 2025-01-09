package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 구간 합 구하기 4
 * <p/>
 * https://www.acmicpc.net/problem/11659
 */
public class Problem11659 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nmArr = br.readLine().split(" ");
    int n = Integer.parseInt(nmArr[0]);
    int m = Integer.parseInt(nmArr[1]);

    String[] numArr = br.readLine().split(" ");

    int[] preSumArr = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      preSumArr[i] = preSumArr[i - 1] + Integer.parseInt(numArr[i - 1]);
    }

    for (int a = 0; a < m; a++) {

      String[] ijArr = br.readLine().split(" ");

      int i = Integer.parseInt(ijArr[0]);
      int j = Integer.parseInt(ijArr[1]);

      int sum = preSumArr[j] - preSumArr[i - 1];

      System.out.println(sum);
    }
  }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nmArr = br.readLine().split(" ");
    int n = Integer.parseInt(nmArr[0]);
    int m = Integer.parseInt(nmArr[1]);

    String[] numArr = br.readLine().split(" ");

    int[] preSumArr = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      preSumArr[i] = preSumArr[i - 1] + Integer.parseInt(numArr[i - 1]);
    }

    for (int a = 0; a <= m; a++) {

      String[] ijArr = br.readLine().split(" ");

      int i = Integer.parseInt(ijArr[0]);
      int j = Integer.parseInt(ijArr[1]);

      int sum = preSumArr[j] - preSumArr[i - 1];

      System.out.println(sum);
    }
  }
}
*/
