package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 절댓값 힙
 * <p/>
 * https://www.acmicpc.net/problem/11286
 */
public class Problem11286 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> numQueue = new PriorityQueue<>(
        (a, b) -> {
          int absA = Math.abs(a);
          int absB = Math.abs(b);
          if (absA != absB) {
            return Integer.compare(absA, absB);
          } else {
            return Integer.compare(a, b);
          }
        }
    );

    while (N > 0) {
      int num = Integer.parseInt(br.readLine());
      if (num == 0) {
        if (numQueue.isEmpty()) {
          System.out.println(0);
        } else {
          System.out.println(numQueue.poll());
        }
      } else {
        numQueue.add(num);
      }
      N--;
    }
  }
}

/*
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> numQueue = new PriorityQueue<>(
        (a, b) -> {
          int absA = Math.abs(a);
          int absB = Math.abs(b);
          if (absA != absB) {
            return Integer.compare(absA, absB);
          } else {
            return Integer.compare(a, b);
          }
        }
    );

    while (N > 0) {
      int num = Integer.parseInt(br.readLine());
      if (num == 0) {
        if (numQueue.isEmpty()) {
          System.out.println(0);
        } else {
          System.out.println(numQueue.poll());
        }
      } else {
        numQueue.add(num);
      }
      N--;
    }
  }
}
*/
