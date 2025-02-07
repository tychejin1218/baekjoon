package fastcampus.part1.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2817 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int X = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());

    double minVoteCnt = X * 0.05;

    Map<String, Integer> staffMap = new HashMap<>();
    while (N-- > 0) {
      String[] staffArr = br.readLine().split(" ");
      String staffNm = staffArr[0];
      int voteCnt = Integer.parseInt(staffArr[1]);
      if (voteCnt >= minVoteCnt) {
        staffMap.put(staffNm, voteCnt);
      }
    }

    List<StaffPoints> scoreList = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : staffMap.entrySet()) {
      String staffNm = entry.getKey();
      int voteCnt = entry.getValue();
      for (int i = 1; i <= 14; i++) {
        scoreList.add(new StaffPoints(staffNm, voteCnt / (double) i));
      }
    }

    scoreList.sort((o1, o2) -> Double.compare(o2.score, o1.score));
    Map<String, Integer> chipMap = new HashMap<>();
    for (int i = 0; i < 14 && i < scoreList.size(); i++) {
      StaffPoints point = scoreList.get(i);
      chipMap.put(point.name, chipMap.getOrDefault(point.name, 0) + 1);
    }

    List<String> resultKeys = new ArrayList<>(chipMap.keySet());
    Collections.sort(resultKeys);

    for (String name : resultKeys) {
      System.out.println(name + " " + chipMap.get(name));
    }
  }

  static class StaffPoints {

    String name;
    double score;

    StaffPoints(String name, double score) {
      this.name = name;
      this.score = score;
    }
  }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int X = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());

    double minVoteCnt = X * 0.05;

    Map<String, Integer> staffMap = new HashMap<>();
    while (N-- > 0) {
      String[] staffArr = br.readLine().split(" ");
      String staffNm = staffArr[0];
      int voteCnt = Integer.parseInt(staffArr[1]);
      if (voteCnt >= minVoteCnt) {
        staffMap.put(staffNm, voteCnt);
      }
    }

    List<StaffPoints> scoreList = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : staffMap.entrySet()) {
      String staffNm = entry.getKey();
      int voteCnt = entry.getValue();
      for (int i = 1; i <= 14; i++) {
        scoreList.add(new StaffPoints(staffNm, voteCnt / (double) i));
      }
    }

    scoreList.sort((o1, o2) -> Double.compare(o2.score, o1.score));
    Map<String, Integer> chipMap = new HashMap<>();
    for (int i = 0; i < 14 && i < scoreList.size(); i++) {
      StaffPoints point = scoreList.get(i);
      chipMap.put(point.name, chipMap.getOrDefault(point.name, 0) + 1);
    }

    List<String> resultKeys = new ArrayList<>(chipMap.keySet());
    Collections.sort(resultKeys);

    for (String name : resultKeys) {
      System.out.println(name + " " + chipMap.get(name));
    }
  }

  static class StaffPoints {

    String name;
    double score;

    StaffPoints(String name, double score) {
      this.name = name;
      this.score = score;
    }
  }
}
*/
