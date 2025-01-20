package fastcampus.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 대소문자바꾸기
 * <p/>
 * https://www.acmicpc.net/problem/2744
 */
public class Problem2744 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    char[] charArr = str.toCharArray();

    StringBuffer sb = new StringBuffer();
    for (char c : charArr) {
      if (c >= 'A' && c <= 'Z') {
        sb.append(Character.toLowerCase(c));
      } else if (c >= 'a' && c <= 'z') {
        sb.append(Character.toUpperCase(c));
      }
    }

    System.out.println(sb);
  }
}

/*
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    char[] charArr = str.toCharArray();

    StringBuffer sb = new StringBuffer();
    for (char c : charArr) {
      if (c >= 'A' && c <= 'Z') {
        sb.append(Character.toLowerCase(c));
      } else if (c >= 'a' && c <= 'z') {
        sb.append(Character.toUpperCase(c));
      }
    }

    System.out.println(sb);
  }
}
*/
