package fastcampus.part1.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Problem2817 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int X = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());

    int minVoteCnt = (int) Math.ceil(X * 0.05);

    Map<String, Integer> staffMap = new HashMap<>();
    while (N-- > 0) {
      String[] staffArr = br.readLine().split(" ");
      String staffNm = staffArr[0];
      int voteCnt = Integer.parseInt(staffArr[1]);
      if (voteCnt >= minVoteCnt) {
        staffMap.put(staffNm, voteCnt);
      }
    }

    PriorityQueue<StaffPoints> scoreQueue = new PriorityQueue<>();
    for (Map.Entry<String, Integer> entry : staffMap.entrySet()) {
      String staffNm = entry.getKey();
      int voteCnt = entry.getValue();
      for (int i = 1; i <= 14; i++) {
        double score = voteCnt / (double) i;
        scoreQueue.add(new StaffPoints(staffNm, score));
        if (scoreQueue.size() > 14) {
          scoreQueue.poll();
        }
      }
    }

    Map<String, Integer> chipMap = new TreeMap<>();
    while (!scoreQueue.isEmpty()) {
      StaffPoints sp = scoreQueue.poll();
      chipMap.put(sp.name, chipMap.getOrDefault(sp.name, 0) + 1);
    }

    for (Map.Entry<String, Integer> entry : chipMap.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }

  static class StaffPoints implements Comparable<StaffPoints> {

    String name;
    double score;

    StaffPoints(String name, double score) {
      this.name = name;
      this.score = score;
    }

    @Override
    public int compareTo(StaffPoints other) {
      return Double.compare(this.score, other.score);
    }
  }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int X = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());

    int minVoteCnt = (int) Math.ceil(X * 0.05);

    Map<String, Integer> staffMap = new HashMap<>();
    while (N-- > 0) {
      String[] staffArr = br.readLine().split(" ");
      String staffNm = staffArr[0];
      int voteCnt = Integer.parseInt(staffArr[1]);
      if (voteCnt >= minVoteCnt) {
        staffMap.put(staffNm, voteCnt);
      }
    }

    PriorityQueue<StaffPoints> scoreQueue = new PriorityQueue<>();
    for (Map.Entry<String, Integer> entry : staffMap.entrySet()) {
      String staffNm = entry.getKey();
      int voteCnt = entry.getValue();
      for (int i = 1; i <= 14; i++) {
        double score = voteCnt / (double) i;
        scoreQueue.add(new StaffPoints(staffNm, score));
        if (scoreQueue.size() > 14) {
          scoreQueue.poll();
        }
      }
    }

    Map<String, Integer> chipMap = new TreeMap<>();
    while (!scoreQueue.isEmpty()) {
      StaffPoints sp = scoreQueue.poll();
      chipMap.put(sp.name, chipMap.getOrDefault(sp.name, 0) + 1);
    }

    for (Map.Entry<String, Integer> entry : chipMap.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }

  static class StaffPoints implements Comparable<StaffPoints> {

    String name;
    double score;

    StaffPoints(String name, double score) {
      this.name = name;
      this.score = score;
    }

    @Override
    public int compareTo(StaffPoints other) {
      return Double.compare(this.score, other.score);
    }
  }
}
*/
