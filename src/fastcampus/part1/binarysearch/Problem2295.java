package fastcampus.part1.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 세 수의 합
 * <p/>
 * https://www.acmicpc.net/problem/2295
 */
public class Problem2295 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    bw.write(getSum(arr, N) + "\n");
    bw.flush();
    bw.close();
  }

  static int getSum(int[] arr, int N) {

    // 집합(Set)을 사용하여 값을 빠르게 탐색
    Set<Integer> set = new HashSet<>();
    for (int num : arr) {
      set.add(num);
    }

    // 가장 큰 d부터 탐색
    for (int k = N - 1; k >= 0; k--) {
      // 두 수의 합을 동적으로 처리
      for (int i = 0; i < k; i++) {
        for (int j = i; j < k; j++) {
          int sum = arr[i] + arr[j];
          if (set.contains(arr[k] - sum)) { // arr[k]를 만들 수 있는지 확인
            return arr[k];
          }
        }
      }
    }

    return 0;
  }
}


/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    bw.write(getSum(arr, N) + "\n");
    bw.flush();
    bw.close();
  }

  static int getSum(int[] arr, int N) {

    // 집합(Set)을 사용하여 값을 빠르게 탐색
    Set<Integer> set = new HashSet<>();
    for (int num : arr) {
      set.add(num);
    }

    // 가장 큰 d부터 탐색
    for (int k = N - 1; k >= 0; k--) {
      // 두 수의 합을 동적으로 처리
      for (int i = 0; i < k; i++) {
        for (int j = i; j < k; j++) {
          int sum = arr[i] + arr[j];
          if (set.contains(arr[k] - sum)) { // arr[k]를 만들 수 있는지 확인
            return arr[k];
          }
        }
      }
    }

    return 0;
  }
}
*/
