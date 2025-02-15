package fastcampus.part1.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 회의실 배정
 *
 * <p>https://www.acmicpc.net/problem/1931</p>
 */
public class Problem1931 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    // 회의 시작 시간과 종료 시간을 저장
    int[][] hourArr = new int[N][2];

    for (int i = 0; i < N; i++) {
      String[] inputArr = br.readLine().split(" ");
      hourArr[i][0] = Integer.parseInt(inputArr[0]);
      hourArr[i][1] = Integer.parseInt(inputArr[1]);
    }

    // 회의를 먼저 끝내는 순으로 정렬, 종료 시간이 같을 경우 시작 시간이 빠른 순으로 정렬
    Arrays.sort(hourArr,
        (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

    int end = -1;
    int count = 0;

    for (int i = 0; i < N; i++) {
      // 회의 시작 시간이 이전에 종료된 회의의 종료 시간보다 늦다면 해당 회의를 배정
      if (hourArr[i][0] >= end) {
        end = hourArr[i][1];
        count++;
      }
    }

    bw.write(count + "\n");
    bw.flush();
  }
}
