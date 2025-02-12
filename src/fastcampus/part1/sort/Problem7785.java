package fastcampus.part1.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 회사에 있는 사람
 * <p/>
 * https://www.acmicpc.net/problem/7785
 */
public class Problem7785 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Set<String> userSet = new HashSet<>();
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String[] log = br.readLine().split(" ");
      String name = log[0];
      String action = log[1];

      if ("enter".equals(action)) {
        userSet.add(name);
      } else {
        userSet.remove(name);
      }
    }

    List<String> currentEmployees = new ArrayList<>(userSet);
    Collections.sort(currentEmployees, Collections.reverseOrder());

    for (String name : currentEmployees) {
      bw.write(name + "\n");
    }

    bw.flush();
  }
}
