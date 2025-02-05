package fastcampus.part1.complexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 개미
 * <p/>
 * https://www.acmicpc.net/problem/10158
 */
public class Problem10158 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] targetArr = br.readLine().split(" ");
    String[] startArr = br.readLine().split(" ");
    int step = Integer.parseInt(br.readLine());

    int targetX = Integer.parseInt(targetArr[0]);
    int targetY = Integer.parseInt(targetArr[1]);

    int currentX = Integer.parseInt(startArr[0]);
    int currentY = Integer.parseInt(startArr[1]);

    int finalX = (currentX + step) % (2 * targetX);
    if (finalX > targetX) {
      finalX = 2 * targetX - finalX;
    }

    int finalY = (currentY + step) % (2 * targetY);
    if (finalY > targetY) {
      finalY = 2 * targetY - finalY;
    }

    System.out.println(finalX + " " + finalY);
  }
}

/*
04 14 24 34 44 54 64
03 13 23 33 43 53 63
02 12 22 32 42 52 62
01 11 21 31 41 51 61
00 10 20 30 40 50 60
*/

/*
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] targetArr = br.readLine().split(" ");
    String[] startArr = br.readLine().split(" ");
    int step = Integer.parseInt(br.readLine());

    int targetX = Integer.parseInt(targetArr[0]);
    int targetY = Integer.parseInt(targetArr[1]);

    int currentX = Integer.parseInt(startArr[0]);
    int currentY = Integer.parseInt(startArr[1]);

    int finalX = (currentX + step) % (2 * targetX);
    if (finalX > targetX) {
      finalX = 2 * targetX - finalX;
    }

    int finalY = (currentY + step) % (2 * targetY);
    if (finalY > targetY) {
      finalY = 2 * targetY - finalY;
    }

    System.out.println(finalX + " " + finalY);
  }
}
*/
