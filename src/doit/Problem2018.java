package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수들의 합 5
 * <p/>
 * https://www.acmicpc.net/problem/2018
 */
public class Problem2018 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

    int count = 1;
    int sNum = 1;
    int eNum = (num / 2) + 1;

    while (sNum != eNum) {
      int sum = 0;
      for (int i = sNum; i <= eNum; i++) {
        sum += i;
        if (sum == num) {
          count++;
          sNum++;
        } else if(sum > num) {
          sNum++;
          break;
        }
      }
    }

    System.out.println(count);
  }
}

/*
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

    int count = 1;
    int sNum = 1;
    int eNum = (num / 2) + 1;

    while (sNum != eNum) {
      int sum = 0;
      for (int i = sNum; i <= eNum; i++) {
        sum += i;
        if (sum == num) {
          count++;
          sNum++;
        } else if(sum > num) {
          sNum++;
          break;
        }
      }
    }

    System.out.println(count);
  }
}
*/
