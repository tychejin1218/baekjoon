package fastcampus.part1.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 유레카 이론
 * <p/>
 * https://www.acmicpc.net/problem/10448
 */
public class Problem10448 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    List<Integer> triNumList = getTriNumList();

    StringBuilder sb = new StringBuilder();
    while (T > 0) {
      int K = Integer.parseInt(br.readLine());
      sb.append(isTriNum(K, triNumList)).append("\n");
      T--;
    }

    System.out.println(sb);
  }

  public static List<Integer> getTriNumList() {

    List<Integer> numArr = new ArrayList<>();

    int num;
    int idx = 1;

    while (true) {
      num = (idx * (idx + 1)) / 2;
      if (num > 1000) {
        break;
      }
      numArr.add(num);
      idx++;
    }

    return numArr;
  }

  public static int isTriNum(int K, List<Integer> triNumList) {

    for (int i = 0; i < triNumList.size(); i++) {
      for (int j = 0; j < triNumList.size(); j++) {
        for (int k = 0; k < triNumList.size(); k++) {
          if (K == (triNumList.get(i) + triNumList.get(j) + triNumList.get(k))) {
            return 1;
          }
        }
      }
    }
    return 0;
  }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    List<Integer> triNumList = getTriNumList();

    StringBuilder sb = new StringBuilder();
    while (T > 0) {
      int K = Integer.parseInt(br.readLine());
      sb.append(isTriNum(K, triNumList)).append("\n");
      T--;
    }

    System.out.println(sb);
  }

  public static List<Integer> getTriNumList() {

    List<Integer> numArr = new ArrayList<>();

    int num;
    int idx = 1;

    while (true) {
      num = (idx * (idx + 1)) / 2;
      if (num > 1000) {
        break;
      }
      numArr.add(num);
      idx++;
    }

    return numArr;
  }

  public static int isTriNum(int K, List<Integer> triNumList) {

    for (int i = 0; i < triNumList.size(); i++) {
      for (int j = 0; j < triNumList.size(); j++) {
        for (int k = 0; k < triNumList.size(); k++) {
          if (K == (triNumList.get(i) + triNumList.get(j) + triNumList.get(k))) {
            return 1;
          }
        }
      }
    }
    return 0;
  }
}
*/
