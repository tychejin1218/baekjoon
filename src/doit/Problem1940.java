package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 주몽
 * <p/>
 * https://www.acmicpc.net/problem/1940
 */
public class Problem1940 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    String[] strArr = br.readLine().split(" ");

    int[] numArr = new int[n];
    for (int i = 0; i < numArr.length; i++) {
      numArr[i] = Integer.parseInt(strArr[i]);
    }

    Arrays.sort(numArr);

    int sIdx = 0;
    int eIdx = n - 1;
    int count = 0;

    while (sIdx < eIdx) {

      int sum = numArr[sIdx] + numArr[eIdx];
      if (sum == m) {
        sIdx++;
        eIdx--;
        count++;
      } else if (sum < m) {
        sIdx++;
      } else {
        eIdx--;
      }
    }

    System.out.println(count);
  }
}

/*
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    String[] strArr = br.readLine().split(" ");

    int[] numArr = new int[n];
    for (int i = 0; i < numArr.length; i++) {
      numArr[i] = Integer.parseInt(strArr[i]);
    }

    Arrays.sort(numArr);

    int sIdx = 0;
    int eIdx = n - 1;
    int count = 0;

    while (sIdx < eIdx) {

      int sum = numArr[sIdx] + numArr[eIdx];
      if (sum == m) {
        sIdx++;
        eIdx--;
        count++;
      } else if (sum < m) {
        sIdx++;
      } else {
        eIdx--;
      }
    }

    System.out.println(count);
  }
}
*/
