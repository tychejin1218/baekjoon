package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DNA 비밀번호
 * <p/>
 * https://www.acmicpc.net/problem/12891
 */
public class Problem12891 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] sp = br.readLine().split(" ");
    int s = Integer.parseInt(sp[0]); // 9
    int p = Integer.parseInt(sp[1]); // 8

    char[] iDna = br.readLine().toCharArray(); // CCTGGATTG

    String iDnaCount = br.readLine(); // 2 0 1 1
    String[] iDnaCountArr = iDnaCount.split(" ");

    int[] chkDnaCountArr = new int[4];
    for (int i = 0; i < 4; i++) {
      chkDnaCountArr[i] = Integer.parseInt(iDnaCountArr[i]);
    }

    int[] curDnaCountArr = new int[4];
    for (int i = 0; i < p; i++) {
      addDnaCount(iDna[i], curDnaCountArr);
    }

    int dnaCount = 0;
    if (isDna(curDnaCountArr, chkDnaCountArr)) {
      dnaCount++;
    }

    for (int i = p; i < s; i++) {
      addDnaCount(iDna[i], curDnaCountArr);
      removeDnaCount(iDna[i - p], curDnaCountArr);

      if (isDna(curDnaCountArr, chkDnaCountArr)) {
        dnaCount++;
      }
    }

    System.out.println(dnaCount);
  }

  public static void addDnaCount(char charDna, int[] dnaCount) {
    if (charDna == 'A') {
      dnaCount[0]++;
    } else if (charDna == 'C') {
      dnaCount[1]++;
    } else if (charDna == 'G') {
      dnaCount[2]++;
    } else if (charDna == 'T') {
      dnaCount[3]++;
    }
  }

  public static void removeDnaCount(char charDna, int[] dnaCount) {
    if (charDna == 'A') {
      dnaCount[0]--;
    } else if (charDna == 'C') {
      dnaCount[1]--;
    } else if (charDna == 'G') {
      dnaCount[2]--;
    } else if (charDna == 'T') {
      dnaCount[3]--;
    }
  }

  public static boolean isDna(int[] curDnaCountArr, int[] chkDnaCountArr) {
    for (int i = 0; i < 4; i++) {
      if (curDnaCountArr[i] < chkDnaCountArr[i]) {
        return false;
      }
    }
    return true;
  }
}

/*

import java.io.*;

public class Main {

public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] sp = br.readLine().split(" ");
    int s = Integer.parseInt(sp[0]); // 9
    int p = Integer.parseInt(sp[1]); // 8

    char[] iDna = br.readLine().toCharArray(); // CCTGGATTG

    String iDnaCount = br.readLine(); // 2 0 1 1
    String[] iDnaCountArr = iDnaCount.split(" ");

    int[] chkDnaCountArr = new int[4];
    for (int i = 0; i < 4; i++) {
      chkDnaCountArr[i] = Integer.parseInt(iDnaCountArr[i]);
    }

    int[] curDnaCountArr = new int[4];
    for (int i = 0; i < p; i++) {
      addDnaCount(iDna[i], curDnaCountArr);
    }

    int dnaCount = 0;
    if (isDna(curDnaCountArr, chkDnaCountArr)) {
      dnaCount++;
    }

    for (int i = p; i < s; i++) {
      addDnaCount(iDna[i], curDnaCountArr);
      removeDnaCount(iDna[i - p], curDnaCountArr);

      if (isDna(curDnaCountArr, chkDnaCountArr)) {
        dnaCount++;
      }
    }

    System.out.println(dnaCount);
  }

  public static void addDnaCount(char charDna, int[] dnaCount) {
    if (charDna == 'A') {
      dnaCount[0]++;
    } else if (charDna == 'C') {
      dnaCount[1]++;
    } else if (charDna == 'G') {
      dnaCount[2]++;
    } else if (charDna == 'T') {
      dnaCount[3]++;
    }
  }

  public static void removeDnaCount(char charDna, int[] dnaCount) {
    if (charDna == 'A') {
      dnaCount[0]--;
    } else if (charDna == 'C') {
      dnaCount[1]--;
    } else if (charDna == 'G') {
      dnaCount[2]--;
    } else if (charDna == 'T') {
      dnaCount[3]--;
    }
  }

  public static boolean isDna(int[] curDnaCountArr, int[] chkDnaCountArr) {
    for (int i = 0; i < 4; i++) {
      if (curDnaCountArr[i] < chkDnaCountArr[i]) {
        return false;
      }
    }
    return true;
  }
}
*/
