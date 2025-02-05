package fastcampus.part1.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ACM 호텔
 * <p/>
 * https://www.acmicpc.net/problem/10250
 */
public class Problem10250 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {

      String[] inputArr = br.readLine().split(" ");
      int H = Integer.parseInt(inputArr[0]);
      int W = Integer.parseInt(inputArr[1]);
      int N = Integer.parseInt(inputArr[2]);

      int checkCount = 1;
      Loop1:
      for (int i = 1; i <= W; i++) {
        for (int j = 1; j <= H; j++) {
          if (checkCount == N) {
            System.out.println(j + String.format("%02d", i));
            break Loop1;
          }
          checkCount++;
        }
      }
    }
  }
}

/*
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {

      String[] inputArr = br.readLine().split(" ");
      int H = Integer.parseInt(inputArr[0]);
      int W = Integer.parseInt(inputArr[1]);
      int N = Integer.parseInt(inputArr[2]);

      int checkCount = 1;
      Loop1:
      for (int i = 1; i <= W; i++) {
        for (int j = 1; j <= H; j++) {
          if (checkCount == N) {
            System.out.println(j + String.format("%02d", i));
            break Loop1;
          }
          checkCount++;
        }
      }
    }
  }
}
*/
