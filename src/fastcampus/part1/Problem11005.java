package fastcampus.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 진법 변환 2
 * <p/>
 * https://www.acmicpc.net/problem/11005
 */
public class Problem11005 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    long number = Integer.parseInt(input[0]);
    int base = Integer.parseInt(input[1]);

    StringBuilder sb = new StringBuilder();

    while (number > 0) {

      int remainder = (int) number % base;

      char digit = (char) (remainder < 10 ? '0' + remainder : 'A' + (remainder - 10));
      sb.append(digit);

      number /= base;
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
    String[] input = br.readLine().split(" ");
    long number = Integer.parseInt(input[0]);
    int base = Integer.parseInt(input[1]);

    StringBuilder sb = new StringBuilder();

    while (number > 0) {

      int remainder = (int) (number % base);

      char digit = (char) (remainder < 10 ? '0' + remainder : 'A' + (remainder - 10));
      sb.append(digit);

      number /= base;
    }

    System.out.println(sb.reverse());
  }
}
*/
