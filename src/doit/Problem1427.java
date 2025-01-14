package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 소트인사이드 성공
 * <p/>
 * https://www.acmicpc.net/problem/1427
 */
public class Problem1427 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String N = br.readLine();
    char[] nArr = N.toCharArray();

    int[] numArr = new int[nArr.length];
    for (int i = 0; i < nArr.length; i++) {
      int num = Character.getNumericValue(nArr[i]);
      numArr[i] = num;
    }

    StringBuilder sb = new StringBuilder();
    Arrays.sort(numArr);
    for (int i = numArr.length - 1; i >= 0; i--) {
      sb.append(numArr[i]);
    }
    System.out.println(sb);
  }
}

/*
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String N = br.readLine();
    char[] nArr = N.toCharArray();

    int[] numArr = new int[nArr.length];
    for (int i = 0; i < nArr.length; i++) {
      int num = Character.getNumericValue(nArr[i]);
      numArr[i] = num;
    }

    StringBuilder sb = new StringBuilder();
    Arrays.sort(numArr);
    for (int i = numArr.length - 1; i >= 0; i--) {
      sb.append(numArr[i]);
    }
    System.out.println(sb);
  }
}
*/
