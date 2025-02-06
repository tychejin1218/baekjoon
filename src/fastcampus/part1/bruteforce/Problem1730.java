package fastcampus.part1.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1730 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    String[][] posArr = new String[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        posArr[i][j] = ".";
      }
    }

    int curX = 0, curY = 0;
    int preX, preY;

    char[] comArr = br.readLine().toCharArray();
    for (char com : comArr) {

      preX = curX;
      preY = curY;

      if (com == 'U' && curX > 0) { // '|'
        curX--;
      } else if (com == 'D' && curX < N - 1) { // '|'
        curX++;
      } else if (com == 'L' && curY > 0) { // '-'
        curY--;
      } else if (com == 'R' && curY < N - 1) { // '-'
        curY++;
      }

      if (curX != preX) {
        if ("-".equals(posArr[preX][preY])) {
          posArr[preX][preY] = "+";
        } else if (!"+".equals(posArr[preX][preY])) {
          posArr[preX][preY] = "|";
        }
      }

      if (curY != preY) {
        if ("|".equals(posArr[preX][preY])) {
          posArr[preX][preY] = "+";
        } else if (!"+".equals(posArr[preX][preY])) {
          posArr[preX][preY] = "-";
        }
      }

      if (curX != preX) {
        if ("-".equals(posArr[curX][curY])) {
          posArr[curX][curY] = "+";
        } else if (!"+".equals(posArr[curX][curY])) {
          posArr[curX][curY] = "|";
        }
      }

      if (curY != preY) {
        if ("|".equals(posArr[curX][curY])) {
          posArr[curX][curY] = "+";
        } else if (!"+".equals(posArr[curX][curY])) {
          posArr[curX][curY] = "-";
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(posArr[i][j]);
      }
      System.out.println();
    }
  }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    String[][] posArr = new String[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        posArr[i][j] = ".";
      }
    }

    int curX = 0, curY = 0;
    int preX, preY;

    char[] comArr = br.readLine().toCharArray();
    for (char com : comArr) {

      preX = curX;
      preY = curY;

      if (com == 'U' && curX > 0) { // '|'
        curX--;
      } else if (com == 'D' && curX < N - 1) { // '|'
        curX++;
      } else if (com == 'L' && curY > 0) { // '-'
        curY--;
      } else if (com == 'R' && curY < N - 1) { // '-'
        curY++;
      }

      if (curX != preX) {
        if ("-".equals(posArr[preX][preY])) {
          posArr[preX][preY] = "+";
        } else if (!"+".equals(posArr[preX][preY])) {
          posArr[preX][preY] = "|";
        }
      }

      if (curY != preY) {
        if ("|".equals(posArr[preX][preY])) {
          posArr[preX][preY] = "+";
        } else if (!"+".equals(posArr[preX][preY])) {
          posArr[preX][preY] = "-";
        }
      }

      if (curX != preX) {
        if ("-".equals(posArr[curX][curY])) {
          posArr[curX][curY] = "+";
        } else if (!"+".equals(posArr[curX][curY])) {
          posArr[curX][curY] = "|";
        }
      }

      if (curY != preY) {
        if ("|".equals(posArr[curX][curY])) {
          posArr[curX][curY] = "+";
        } else if (!"+".equals(posArr[curX][curY])) {
          posArr[curX][curY] = "-";
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(posArr[i][j]);
      }
      System.out.println();
    }
  }
}
*/
