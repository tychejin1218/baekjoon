package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택 수열
 * <p/>
 * https://www.acmicpc.net/problem/1874
 */
public class Problem1874 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    StringBuilder result = new StringBuilder();

    int current = 1;
    boolean isPossible = true;

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

      while (current <= num) {
        stack.push(current);
        result.append("+\n");
        current++;
      }

      if (stack.peek() == num) {
        stack.pop();
        result.append("-\n");
      } else {
        isPossible = false;
        break;
      }
    }

    if (!isPossible) {
      System.out.println("NO");
    } else {
      System.out.print(result);
    }
  }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    StringBuilder result = new StringBuilder();

    int current = 1;
    boolean isPossible = true;

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

      while (current <= num) {
        stack.push(current);
        result.append("+\n");
        current++;
      }

      if (stack.peek() == num) {
        stack.pop();
        result.append("-\n");
      } else {
        isPossible = false;
        break;
      }
    }

    if (!isPossible) {
      System.out.println("NO");
    } else {
      System.out.print(result);
    }
  }
}
*/
