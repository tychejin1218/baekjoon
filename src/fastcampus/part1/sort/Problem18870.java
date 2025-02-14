package fastcampus.part1.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 좌표 압축
 * <p/>
 * https://www.acmicpc.net/problem/18870
 */
public class Problem18870 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String[] inputStrArr = br.readLine().split(" ");

    Set<String> posSet = new HashSet<>();
    Collections.addAll(posSet, inputStrArr);

    int[] posArr = posSet.stream()
        .mapToInt(Integer::valueOf)
        .toArray();
    Arrays.sort(posArr);

    Map<String, Integer> posMap = new HashMap<>();
    for (int i = 0; i < posArr.length; i++) {
      posMap.put(String.valueOf(posArr[i]), i);
    }

    for (String inputStr : inputStrArr) {
      bw.write(posMap.get(inputStr) + " ");
    }

    bw.flush();
  }
}

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String[] inputStrArr = br.readLine().split(" ");

    Set<String> posSet = new HashSet<>();
    Collections.addAll(posSet, inputStrArr);

    int[] posArr = posSet.stream()
        .mapToInt(Integer::valueOf)
        .toArray();
    Arrays.sort(posArr);

    Map<String, Integer> posMap = new HashMap<>();
    for (int i = 0; i < posArr.length; i++) {
      posMap.put(String.valueOf(posArr[i]), i);
    }

    for (String inputStr : inputStrArr) {
      bw.write(posMap.get(inputStr) + " ");
    }

    bw.flush();
  }
}
*/
