package fastcampus.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 애너그램만들기
 * <p/>
 * https://www.acmicpc.net/problem/1919
 */
public class Problem1919 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str1 = br.readLine();
    String str2 = br.readLine();

    char[] charArr1 = str1.toCharArray();
    char[] charArr2 = str2.toCharArray();

    char[] countArr1 = new char[26];
    char[] countArr2 = new char[26];

    for (char c : charArr1) {
      countArr1[c - 'a']++;
    }

    for (char c : charArr2) {
      countArr2[c - 'a']++;
    }

    int count = 0;
    for (int i = 0; i < 26; i++) {
      count += Math.abs(countArr1[i] - countArr2[i]);
    }

    System.out.println(count);
  }
}


/*
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str1 = br.readLine();
    String str2 = br.readLine();

    char[] charArr1 = str1.toCharArray();
    char[] charArr2 = str2.toCharArray();

    char[] countArr1 = new char[26];
    char[] countArr2 = new char[26];

    for (char c : charArr1) {
      countArr1[c - 'a']++;
    }

    for (char c : charArr2) {
      countArr2[c - 'a']++;
    }

    int count = 0;
    for (int i = 0; i < 26; i++) {
      count += Math.abs(countArr1[i] - countArr2[i]);
    }

    System.out.println(count);
  }
}
*/
