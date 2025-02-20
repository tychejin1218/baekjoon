package fastcampus.part1.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문자열 집합
 * <p/>
 * https://www.acmicpc.net/problem/14425
 */
public class Problem14425 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    String[] nArr = new String[N];
    for (int i = 0; i < N; i++) {
      nArr[i] = br.readLine();
    }

    Arrays.sort(nArr);

    int count = 0;
    while (M-- > 0) {
      String mStr = br.readLine();
      if (Arrays.binarySearch(nArr, mStr) >= 0) {
        count++;
      }
    }

    bw.write(count + "\n");
    bw.flush();
    bw.close();
  }

  /*static boolean binarySearch(String[] arr, String str, int lIdx, int rIdx) {

    if (lIdx > rIdx) {
      return false;
    }

    int mIdx = (lIdx + rIdx) / 2;

    if (str.equals(arr[mIdx])) {
      return true;
    } else if (str.compareTo(arr[mIdx]) < 0) {
      return binarySearch(arr, str, lIdx, mIdx - 1);
    } else {
      return binarySearch(arr, str, mIdx + 1, rIdx);
    }
  }*/
}


/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    String[] nArr = new String[N];
    for (int i = 0; i < N; i++) {
      nArr[i] = br.readLine();
    }

    Arrays.sort(nArr);

    int count = 0;
    while (M-- > 0) {
      String mStr = br.readLine();
      if (Arrays.binarySearch(nArr, mStr) >= 0) {
        count++;
      }
    }

    bw.write(count + "\n");
    bw.flush();
    bw.close();
  }
}
*/
