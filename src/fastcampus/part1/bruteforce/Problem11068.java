package fastcampus.part1.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 회문인 수
 * <p/>
 * https://www.acmicpc.net/problem/11068
 */
public class Problem11068 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    int[] numberArr = new int[T];
    int[] resultArr = new int[T];
    for (int i = 0; i < T; i++) {
      numberArr[i] = Integer.parseInt(br.readLine());
      resultArr[i] = 0;
    }

    for (int i = 0; i < numberArr.length; i++) {
      for (int j = 2; j <= 64; j++) {
        int number = numberArr[i];
        if (isCheck(number, j)) {
          resultArr[i] = 1;
        }
      }
    }

    for (int result : resultArr) {
      System.out.println(result);
    }
  }

  public static Boolean isCheck(int number, int base) {

    StringBuilder sb = new StringBuilder();

    while (number > 0) {
      int remainder = number % base;
      char digit;

      if (remainder < 10) { // '0'-'9'
        digit = (char) ('0' + remainder);
      } else if (remainder < 36) { // 'A'-'Z'
        digit = (char) ('A' + (remainder - 10));
      } else if (remainder < 62) { // 'a'-'z'
        digit = (char) ('a' + (remainder - 36));
      } else if (remainder == 62) { // 추가 문자 '+'
        digit = '+';
      } else { // 추가 문자 '/'
        digit = '/';
      }

      sb.append(digit);
      number /= base;
    }

    if (sb.toString().equals(sb.reverse().toString())) {
      return true;
    }

    return false;
  }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    int[] numberArr = new int[T];
    int[] resultArr = new int[T];
    for (int i = 0; i < T; i++) {
      numberArr[i] = Integer.parseInt(br.readLine());
      resultArr[i] = 0;
    }

    for (int i = 0; i < numberArr.length; i++) {
      for (int j = 2; j <= 64; j++) {
        int number = numberArr[i];
        if (isCheck(number, j)) {
          resultArr[i] = 1;
        }
      }
    }

    for (int result : resultArr) {
      System.out.println(result);
    }
  }

  public static Boolean isCheck(int number, int base) {

    StringBuilder sb = new StringBuilder();

    while (number > 0) {
      int remainder = number % base;
      char digit;

      if (remainder < 10) { // '0'-'9'
        digit = (char) ('0' + remainder);
      } else if (remainder < 36) { // 'A'-'Z'
        digit = (char) ('A' + (remainder - 10));
      } else if (remainder < 62) { // 'a'-'z'
        digit = (char) ('a' + (remainder - 36));
      } else if (remainder == 62) { // 추가 문자 '+'
        digit = '+';
      } else { // 추가 문자 '/'
        digit = '/';
      }

      sb.append(digit);
      number /= base;
    }

    if (sb.toString().equals(sb.reverse().toString())) {
      return true;
    }

    return false;
  }
}
*/
