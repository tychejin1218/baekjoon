package fastcampus.part1.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 두 수의 합
 * <p/>
 * https://www.acmicpc.net/problem/3273
 */
public class Problem3273 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String[] inputArr = br.readLine().split(" ");

    int X = Integer.parseInt(br.readLine());

    int[] numArr = new int[N];
    for (int i = 0; i < inputArr.length; i++) {
      numArr[i] = Integer.parseInt(inputArr[i]);
    }
    Arrays.sort(numArr);

    int count = 0;
    int sNumIdx = 0;
    int eNumIdx = N - 1;

    while (sNumIdx < eNumIdx) {

      int numSum = numArr[sNumIdx] + numArr[eNumIdx];

      if (numSum == X) {
        sNumIdx++;
        eNumIdx--;
        count++;
      } else if (numSum < X) {
        sNumIdx++;
      } else {
        eNumIdx--;
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

    int N = Integer.parseInt(br.readLine());
    String[] inputArr = br.readLine().split(" ");

    int X = Integer.parseInt(br.readLine());

    int[] numArr = new int[N];
    for (int i = 0; i < inputArr.length; i++) {
      numArr[i] = Integer.parseInt(inputArr[i]);
    }
    Arrays.sort(numArr);

    int count = 0;
    int sNumIdx = 0;
    int eNumIdx = N - 1;

    while (sNumIdx < eNumIdx) {

      int numSum = numArr[sNumIdx] + numArr[eNumIdx];

      if (numSum == X) {
        sNumIdx++;
        eNumIdx--;
        count++;
      } else if (numSum < X) {
        sNumIdx++;
      } else {
        eNumIdx--;
      }
    }

    System.out.println(count);
  }
}
*/
