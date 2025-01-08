package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자의 합
 * <p/>
 * https://www.acmicpc.net/problem/11720
 */
public class Problem11720 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String numLen = String.valueOf(br.readLine());
    String num = String.valueOf(br.readLine());

    int sum = 0;
    char[] charNums = num.toCharArray();
    for (char charNum : charNums) {
      sum += Character.getNumericValue(charNum);
    }

    System.out.println(sum);
  }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String numLen = String.valueOf(br.readLine());
    String num = String.valueOf(br.readLine());

    int sum = 0;
    char[] charNums = num.toCharArray();
    for (char charNum : charNums) {
      sum += Character.getNumericValue(charNum);
    }

    System.out.println(sum);
  }
}
*/
