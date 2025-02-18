package fastcampus.part1.prefixsum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 생명 게임
 * <p/>
 * https://www.acmicpc.net/problem/17232
 */
public class Problem17232 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int T = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    char[][] boardArr = new char[N][M];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        boardArr[i][j] = line.charAt(j);
      }
    }

    // T 시간 동안 시뮬레이션
    while (T-- > 0) {
      char[][] nextBoard = new char[N][M]; // 다음 상태 저장

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          int aliveCount = countAlive(boardArr, N, M, K, i, j); // 주위의 생명 수 계산

          if (boardArr[i][j] == '*') {
            // 현재 칸이 생명 있는 경우
            if (aliveCount >= a && aliveCount <= b) {
              nextBoard[i][j] = '*'; // 생존
            } else {
              nextBoard[i][j] = '.'; // 사망 (고독 또는 과밀)
            }
          } else {
            // 현재 칸이 빈칸인 경우
            if (aliveCount > a && aliveCount <= b) {
              nextBoard[i][j] = '*'; // 탄생
            } else {
              nextBoard[i][j] = '.'; // 그대로 빈칸
            }
          }
        }
      }
      // 다음 상태로 board 갱신
      boardArr = nextBoard;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        sb.append(boardArr[i][j]);
      }
      sb.append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  // 주위의 생명 수를 계산하는 메서드
  private static int countAlive(char[][] board, int N, int M, int K, int x, int y) {
    int count = 0;

    // 중심 좌표의 (K x K) 주변 계산
    for (int i = x - K; i <= x + K; i++) {
      for (int j = y - K; j <= y + K; j++) {
        // 범위를 벗어난 칸은 제외
        if (i < 0 || i >= N || j < 0 || j >= M || (i == x && j == y)) continue;

        if (board[i][j] == '*') count++; // 주위 생명 존재
      }
    }
    return count;
  }
}
