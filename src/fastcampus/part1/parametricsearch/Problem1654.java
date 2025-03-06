package fastcampus.part1.parametricsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 랜선 자르기
 * <p/>
 * https://www.acmicpc.net/problem/1654
 */
public class Problem1654 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    long[] kArr = new long[K];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      kArr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(kArr);

    long count = getTotalCount(kArr, K, N, kArr[kArr.length - 1]);

    System.out.println(count);
  }

  private static long getTotalCount(long[] lengths, int K, int N, long max) {

    long start = 1; // 최소 길이
    long end = max; // 최대 길이
    long totalCount = 0;

    while (start <= end) {
      long mid = (start + end) / 2; // 중간값(시도할 랜선 길이)
      long count = getCount(lengths, K, mid); // mid로 잘랐을 때 랜선 개수 계산

      if (count >= N) {
        totalCount = mid; // 길이를 저장 (조건 만족)
        start = mid + 1; // 더 긴 길이를 시도
      } else {
        end = mid - 1; // 더 짧은 길이를 시도
      }
    }

    return totalCount;
  }

  private static long getCount(long[] lengths, int K, long length) {
    long count = 0;
    for (int i = 0; i < K; i++) {
      count += lengths[i] / length; // 길이 기준으로 랜선 개수 계산
    }
    return count;
  }
}
