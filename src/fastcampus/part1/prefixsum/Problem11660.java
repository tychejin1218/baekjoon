package fastcampus.part1.prefixsum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기 5
 * <p/>
 * https://www.acmicpc.net/problem/11660
 */
public class Problem11660 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] numArr = new int[N + 1][N + 1];
    int[][] prefixSum = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        numArr[i][j] = Integer.parseInt(st.nextToken());

       /*
        + prefixSum[i-1][j]:
        (1, 1)부터 (i-1, j)까지 누적합을 포함 (현재 요소 바로 위의 행까지의 합)

        + prefixSum[i][j-1]:
        (1, 1)부터 (i, j-1)까지 누적합을 포함 (현재 요소 바로 왼쪽 열까지의 합)

        - prefixSum[i-1][j-1]:
        중복으로 더해진 영역 (1, 1)부터 (i-1, j-1)의 합을 제거 (위쪽과 왼쪽 간 중복 처리)

        + numArr[i][j]:
        현재 위치 (i, j)의 값을 더하여 누적합을 완성
        */
        prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1]
            - prefixSum[i - 1][j - 1] + numArr[i][j];
      }
    }

    while (M-- > 0) {

      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int sum = prefixSum[x2][y2]
          - prefixSum[x1 - 1][y2]
          - prefixSum[x2][y1 - 1]
          + prefixSum[x1 - 1][y1 - 1];
      bw.write(sum + "\n");
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

    int[][] numArr = new int[N + 1][N + 1];
    int[][] prefixSum = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        numArr[i][j] = Integer.parseInt(st.nextToken());
        prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1]
            - prefixSum[i - 1][j - 1] + numArr[i][j];
      }
    }

    while (M-- > 0) {

      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int sum = prefixSum[x2][y2]
          - prefixSum[x1 - 1][y2]
          - prefixSum[x2][y1 - 1]
          + prefixSum[x1 - 1][y1 - 1];
      bw.write(sum + "\n");
    }
    bw.flush();
    bw.close();
  }
}
*/
