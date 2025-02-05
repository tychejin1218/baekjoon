package fastcampus.part1.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문서 검색
 * <p/>
 * https://www.acmicpc.net/problem/1543
 */
public class Problem1543 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String target = br.readLine();
    String word = br.readLine();

    int count = 0;
    int index = 0;

    while ((index = target.indexOf(word, index)) != -1) {
      count++;
      index += word.length();
    }

    System.out.println(count);
  }
}

/*
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String target = br.readLine();
    String word = br.readLine();

    int count = 0;
    int index = 0;

    while ((index = target.indexOf(word, index)) != -1) {
      count++;
      index += word.length();
    }

    System.out.println(count);
  }
}
*/
