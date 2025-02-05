package fastcampus.part1.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 줄세우기
 * <p/>
 * https://www.acmicpc.net/problem/10431
 */
public class Problem10431 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int P = Integer.parseInt(br.readLine());

    for (int t = 0; t < P; t++) {

      String[] input = br.readLine().split(" ");
      int testCaseNum = Integer.parseInt(input[0]);

      int[] numArr = new int[20];
      for (int i = 1; i < input.length; i++) {
        numArr[i - 1] = Integer.parseInt(input[i]);
      }

      List<Integer> numList = new ArrayList<>();

      int totalCnt = 0;
      for (int num : numArr) {

        int idx = 0;

        while (idx < numList.size() &&
            numList.get(idx) < num) {
          idx++;
        }

        numList.add(idx, num);

        totalCnt += numList.size() - idx - 1;
      }

      System.out.println(testCaseNum + " " + totalCnt);
    }
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
    int P = Integer.parseInt(br.readLine());

    for (int t = 0; t < P; t++) {

      String[] input = br.readLine().split(" ");
      int testCaseNum = Integer.parseInt(input[0]);

      int[] numArr = new int[20];
      for (int i = 1; i < input.length; i++) {
        numArr[i - 1] = Integer.parseInt(input[i]);
      }

      List<Integer> numList = new ArrayList<>();

      int totalCnt = 0;
      for (int num : numArr) {

        int idx = 0;

        while (idx < numList.size() &&
            numList.get(idx) < num) {
          idx++;
        }

        numList.add(idx, num);

        totalCnt += numList.size() - idx - 1;
      }

      System.out.println(testCaseNum + " " + totalCnt);
    }
  }
}
*/
