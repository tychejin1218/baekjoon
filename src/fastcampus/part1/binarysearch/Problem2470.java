package fastcampus.part1.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 용액
 * <p/>
 * https://www.acmicpc.net/problem/2295
 */
public class Problem2470 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 용액 수 입력
    int[] nArr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nArr[i] = Integer.parseInt(st.nextToken());
    }

    // 1. 정렬
    Arrays.sort(nArr);

    // 2. 두 포인터 탐색
    int left = 0;
    int right = N - 1;
    int closestSum = Integer.MAX_VALUE; // 최솟값 비교
    int finalLeft = 0;  // 최적 왼쪽 포인터
    int finalRight = 0; // 최적 오른쪽 포인터

    while (left < right) { // 두 포인터가 겹치지 않을 때까지
      int sum = nArr[left] + nArr[right];

      // 0에 가까운 값을 찾으면 갱신
      if (Math.abs(sum) < Math.abs(closestSum)) {
        closestSum = sum;
        finalLeft = left;
        finalRight = right;
      }

      // 혼합 값 결정에 따라 포인터 이동
      if (sum > 0) { // 혼합값이 양수라면 값을 줄이기 위해 오른쪽 포인터 이동
        right--;
      } else {       // 혼합값이 음수라면 값을 키우기 위해 왼쪽 포인터 이동
        left++;
      }
    }

    // 3. 결과 출력 (오름차순 보장)
    sb.append(nArr[finalLeft]).append(" ").append(nArr[finalRight]);
    System.out.println(sb.toString());
  }
}
