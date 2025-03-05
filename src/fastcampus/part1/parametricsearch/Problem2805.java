package fastcampus.part1.parametricsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 나무 자르기
 * <p/>
 * https://www.acmicpc.net/problem/2805
 */
public class Problem2805 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] nArr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nArr[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(findMaxHeight(nArr, M));
  }

  // 높이의 최댓값을 찾는 함수 (이분 탐색)
  private static int findMaxHeight(int[] trees, int targetLength) {
    int start = 0;
    int end = Arrays.stream(trees).max().getAsInt();  // 가장 높은 나무의 높이
    int result = 0;  // 절단기의 최대 높이 값

    while (start <= end) {
      int mid = (start + end) / 2;  // 중간값 계산
      long totalLength = getTreeLength(trees, mid);

      if (totalLength >= targetLength) {  // 조건을 만족하면 더 큰 H를 탐색
        result = mid;
        start = mid + 1;
      } else {  // 조건을 만족하지 못하면 더 작은 H를 탐색
        end = mid - 1;
      }
    }

    return result;
  }

  private static long getTreeLength(int[] trees, int cutHeight) {
    long totalLength = 0; // 잘린 나무 총 길이
    for (int tree : trees) {
      if (tree > cutHeight) { // 높이가 절단기보다 클 때만 자름
        totalLength += (tree - cutHeight);
      }
    }
    return totalLength;
  }
}
