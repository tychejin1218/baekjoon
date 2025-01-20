package fastcampus.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 단어공부
 * <p/>
 * https://www.acmicpc.net/problem/1157
 */
public class Problem1157 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine().toLowerCase();

    char[] charArr = str.toCharArray();

    int[] countArr = new int[26];

    for (char c : charArr) {
      countArr[c - 'a']++;
    }

    int maxIdx = Integer.MIN_VALUE;
    int maxCount = Integer.MIN_VALUE;
    boolean isDuplicate = false;

    for (int i = 0; i < countArr.length; i++) {
      int count = countArr[i];
      if (count > maxCount) {
        maxCount = count;
        maxIdx = i;
        isDuplicate = false;
      } else if (count == maxCount) {
        isDuplicate = true;
      }
    }

    if (isDuplicate) {
      System.out.println("?");
    } else {
      System.out.println(Character.toChars(maxIdx + 'A'));
    }
  }
}

/*
import java.io.*

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine().toLowerCase();

    char[] charArr = str.toCharArray();

    int[] countArr = new int[26];

    for (char c : charArr) {
      countArr[c - 'a']++;
    }

    int maxIdx = Integer.MIN_VALUE;
    int maxCount = Integer.MIN_VALUE;
    boolean isDuplicate = false;

    for (int i = 0; i < countArr.length; i++) {
      int count = countArr[i];
      if (count > maxCount) {
        maxCount = count;
        maxIdx = i;
        isDuplicate = false;
      } else if (count == maxCount) {
        isDuplicate = true;
      }
    }

    if (isDuplicate) {
      System.out.println("?");
    } else {
      System.out.println(Character.toChars(maxIdx + 'A'));
    }
  }
}
*/
