package fastcampus.part1.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Generic Queries
 * <p/>
 * https://www.acmicpc.net/problem/16713
 */
public class Problem16713 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());

    int[] array = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      array[i] = Integer.parseInt(st.nextToken());
    }

    int[] prefixXor = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      prefixXor[i] = prefixXor[i - 1] ^ array[i];
    }

    int finalXor = 0;
    while (Q-- > 0) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      int queryXor = prefixXor[e] ^ prefixXor[s - 1];
      finalXor ^= queryXor;
    }

    System.out.println(finalXor);
  }
}



