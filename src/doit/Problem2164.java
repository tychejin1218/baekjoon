package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 카드2
 * <p/>
 * https://www.acmicpc.net/problem/2164
 */
public class Problem2164 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Queue<Integer> nQueue = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      nQueue.add(i);
    }

    while(nQueue.size() > 1) {
      nQueue.poll();
      int num = nQueue.poll();
      nQueue.add(num);
    }

    System.out.println(nQueue.poll());
  }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Queue<Integer> nQueue = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      nQueue.add(i);
    }

    while(nQueue.size() > 1) {
      nQueue.poll();
      int num = nQueue.poll();
      nQueue.add(num);
    }

    System.out.println(nQueue.poll());
  }
}
*/
