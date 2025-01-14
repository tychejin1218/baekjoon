package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 수 정렬하기 성공
 * <p/>
 * https://www.acmicpc.net/problem/2750
 */
public class Problem2750 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] numArr = new int[N];
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      numArr[i] = num;
    }
    Arrays.sort(numArr);

    for (int num : numArr) {
      System.out.println(num);
    }
  }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] numArr = new int[N];
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      numArr[i] = num;
    }
    Arrays.sort(numArr);

    for (int num : numArr) {
      System.out.println(num);
    }
  }
}
*/
