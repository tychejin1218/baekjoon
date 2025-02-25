package fastcampus.part1.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 슷자 카드 2
 * <p/>
 * https://www.acmicpc.net/problem/10816
 */
public class Problem10816 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int[] nArr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nArr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int[] mArr = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      mArr[i] = Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();

    // 정렬된 상태로 nArr 사용
    Arrays.sort(nArr);
    for (int i = 0; i < mArr.length; i++) {

      // 오른쪽 경계 확인
      int firstIndex = lowerBound(nArr, mArr[i]);
      int lastIndex = upperBound(nArr, mArr[i]);

      int count = lastIndex - firstIndex; // 등장 횟수 계산

      sb.append(count).append(" ");
    }

    System.out.println(sb);
  }

  // lowerBound: target 이상인 첫 번째 인덱스 반환
  private static int lowerBound(int[] arr, int target) {
    int left = 0, right = arr.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  // upperBound: target 초과인 첫 번째 인덱스 반환
  private static int upperBound(int[] arr, int target) {
    int left = 0, right = arr.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (arr[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int[] nArr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nArr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int[] mArr = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      mArr[i] = Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();

    // 정렬된 상태로 nArr 사용
    Arrays.sort(nArr);
    for (int i = 0; i < mArr.length; i++) {

      // 오른쪽 경계 확인
      int firstIndex = lowerBound(nArr, mArr[i]);
      int lastIndex = upperBound(nArr, mArr[i]);

      int count = lastIndex - firstIndex; // 등장 횟수 계산

      sb.append(count).append(" ");
    }

    System.out.println(sb);
  }

  // lowerBound: target 이상인 첫 번째 인덱스 반환
  private static int lowerBound(int[] arr, int target) {
    int left = 0, right = arr.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  // upperBound: target 초과인 첫 번째 인덱스 반환
  private static int upperBound(int[] arr, int target) {
    int left = 0, right = arr.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (arr[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
*/
