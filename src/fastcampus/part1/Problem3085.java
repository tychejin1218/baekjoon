package fastcampus.part1;

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