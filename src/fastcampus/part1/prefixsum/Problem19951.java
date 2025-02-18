package fastcampus.part1.prefixsum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 태상이의 훈련소 생활
 * <p/>
 * https://www.acmicpc.net/problem/19951
 */
public class Problem19951 {

  /*public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());


    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    while (M-- > 0) {

      st = new StringTokenizer(br.readLine());
      int sIdx = Integer.parseInt(st.nextToken()) - 1;
      int eIdx = Integer.parseInt(st.nextToken()) - 1;
      int num = Integer.parseInt(st.nextToken());

      for (int i = sIdx; i <= eIdx; i++) {
        arr[i] += num;
      }
    }

    for (int i = 0; i < N; i++) {
      bw.write(arr[i] + " ");
    }

    bw.flush();
    bw.close();
  }*/

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] diff = new int[N + 1];

    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      int sIdx = Integer.parseInt(st.nextToken()) - 1;
      int eIdx = Integer.parseInt(st.nextToken()) - 1;
      int num = Integer.parseInt(st.nextToken());

      diff[sIdx] += num;
      if (eIdx + 1 < N) {
        diff[eIdx + 1] -= num;
      }
    }

    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += diff[i];
      arr[i] += sum;
    }

    for (int i = 0; i < N; i++) {
      bw.write(arr[i] + " ");
    }

    bw.flush();
    bw.close();
  }
}

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] diff = new int[N + 1];

    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      int sIdx = Integer.parseInt(st.nextToken()) - 1;
      int eIdx = Integer.parseInt(st.nextToken()) - 1;
      int num = Integer.parseInt(st.nextToken());

      diff[sIdx] += num;
      if (eIdx + 1 < N) {
        diff[eIdx + 1] -= num;
      }
    }

    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += diff[i];
      arr[i] += sum;
    }

    for (int i = 0; i < N; i++) {
      bw.write(arr[i] + " ");
    }

    bw.flush();
    bw.close();
  }
}
*/
