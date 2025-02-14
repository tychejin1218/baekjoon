package fastcampus.part1.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 빈도 정렬
 *
 * <p>https://www.acmicpc.net/problem/2910</p>
 */
public class Problem2910 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] inputArr = br.readLine().split(" ");
    int N = Integer.parseInt(inputArr[0]);
    int C = Integer.parseInt(inputArr[1]);

    String[] idxArr = br.readLine().split(" ");

    Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
    for (String idx : idxArr) {
      int num = Integer.parseInt(idx);
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    List<Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
    entryList.sort((e1, e2) -> {
      if (!e1.getValue().equals(e2.getValue())) {
        return e2.getValue() - e1.getValue();
      }
      return 0;
    });

    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Integer, Integer> entry : entryList) {
      int num = entry.getKey();
      int freq = entry.getValue();
      for (int i = 0; i < freq; i++) {
        sb.append(num).append(" ");
      }
    }

    bw.write(sb.toString().trim());
    bw.flush();
  }
}

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] inputArr = br.readLine().split(" ");
    int N = Integer.parseInt(inputArr[0]);
    int C = Integer.parseInt(inputArr[1]);

    String[] idxArr = br.readLine().split(" ");

    Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
    for (String idx : idxArr) {
      int num = Integer.parseInt(idx);
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    List<Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
    entryList.sort((e1, e2) -> {
      if (!e1.getValue().equals(e2.getValue())) {
        return e2.getValue() - e1.getValue();
      }
      return 0;
    });

    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Integer, Integer> entry : entryList) {
      int num = entry.getKey();
      int freq = entry.getValue();
      for (int i = 0; i < freq; i++) {
        sb.append(num).append(" ");
      }
    }

    bw.write(sb.toString().trim());
    bw.flush();
  }
}
*/
