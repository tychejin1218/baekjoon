package fastcampus.part1.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 사탕 게임
 * <p/>
 * https://www.acmicpc.net/problem/3085
 */
public class Problem3085 {

  static int n;
  static char[][] map;

  static final int[] dr = {0, 1};
  static final int[] dc = {1, 0};

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    map = new char[n][n];

    for (int i = 0; i < n; i++)
      map[i] = br.readLine().toCharArray();

    int maxCnt = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int dir = 0; dir < 2; dir++) {
          int nr = i + dr[dir];
          int nc = j + dc[dir];

          if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

          swap(i, j, nr, nc);
          int cnt = check();
          if (maxCnt < cnt) maxCnt = cnt;
          swap(i, j, nr, nc);
        }
      }
    }
    System.out.println(maxCnt);
  }

  public static void swap(int r, int c, int nr, int nc) {
    char temp = map[r][c];
    map[r][c] = map[nr][nc];
    map[nr][nc] = temp;
  }

  public static int check() {
    int cnt = 1;
    for (int i = 0; i < n; i++) {
      int tempCnt = 1;
      for (int j = 0; j < n - 1; j++) {
        if (map[i][j] == map[i][j + 1]) tempCnt++;
        else tempCnt = 1;

        if (cnt < tempCnt) cnt = tempCnt;
      }
    }

    for (int i = 0; i < n; i++) {
      int tempCnt = 1;
      for (int j = 0; j < n - 1; j++) {
        if (map[j][i] == map[j + 1][i]) tempCnt++;
        else tempCnt = 1;

        if (cnt < tempCnt) cnt = tempCnt;
      }
    }
    return cnt;
  }

  /**
   * 판화
   * <p/>
   * https://www.acmicpc.net/problem/1730
   */
  public static class Problem1730 {

    public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());

      String[][] dotArr = new String[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          dotArr[i][j] = ".";
        }
      }

      int x = 0;
      int y = 0;

      char[] dirArr = br.readLine().toCharArray();
      for (char dir : dirArr) {
        int preX = x, preY = y; // 이전 위치 저장

        // 방향에 따른 좌표 변경
        if (dir == 'U' && x > 0) {
          x--;
        } else if (dir == 'D' && x < N - 1) {
          x++;
        } else if (dir == 'L' && y > 0) {
          y--;
        } else if (dir == 'R' && y < N - 1) {
          y++;
        }

        // 이전 위치 업데이트
        if (preX == x) { // 수평 이동
          if ("|".equals(dotArr[preX][preY])) {
            dotArr[preX][preY] = "+"; // 교차점 처리
          } else {
            dotArr[preX][preY] = "-"; // 수평 이동 표시
          }
        } else if (preY == y) { // 수직 이동
          if ("-".equals(dotArr[preX][preY])) {
            dotArr[preX][preY] = "+"; // 교차점 처리
          } else {
            dotArr[preX][preY] = "|"; // 수직 이동 표시
          }
        }

        // 새로운 위치 업데이트
        if (preX == x) { // 수평 이동
          if ("|".equals(dotArr[x][y])) {
            dotArr[x][y] = "+"; // 교차점 처리
          } else if (!"-".equals(dotArr[x][y])) {
            dotArr[x][y] = "-"; // 수평 이동 표시
          }
        } else if (preY == y) { // 수직 이동
          if ("-".equals(dotArr[x][y])) {
            dotArr[x][y] = "+"; // 교차점 처리
          } else if (!"|".equals(dotArr[x][y])) {
            dotArr[x][y] = "|"; // 수직 이동 표시
          }
        }
      }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          System.out.print(dotArr[i][j]);
        }
        System.out.println();
      }
    }
  }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int n;
  static char[][] map;

  static final int[] dr = {0, 1};
  static final int[] dc = {1, 0};

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    map = new char[n][n];

    for (int i = 0; i < n; i++)
      map[i] = br.readLine().toCharArray();

    int maxCnt = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int dir = 0; dir < 2; dir++) {
          int nr = i + dr[dir];
          int nc = j + dc[dir];

          if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

          swap(i, j, nr, nc);
          int cnt = check();
          if (maxCnt < cnt) maxCnt = cnt;
          swap(i, j, nr, nc);
        }
      }
    }
    System.out.println(maxCnt);
  }

  public static void swap(int r, int c, int nr, int nc) {
    char temp = map[r][c];
    map[r][c] = map[nr][nc];
    map[nr][nc] = temp;
  }

  public static int check() {
    int cnt = 1;
    for (int i = 0; i < n; i++) {
      int tempCnt = 1;
      for (int j = 0; j < n - 1; j++) {
        if (map[i][j] == map[i][j + 1]) tempCnt++;
        else tempCnt = 1;

        if (cnt < tempCnt) cnt = tempCnt;
      }
    }

    for (int i = 0; i < n; i++) {
      int tempCnt = 1;
      for (int j = 0; j < n - 1; j++) {
        if (map[j][i] == map[j + 1][i]) tempCnt++;
        else tempCnt = 1;

        if (cnt < tempCnt) cnt = tempCnt;
      }
    }
    return cnt;
  }
}
*/
