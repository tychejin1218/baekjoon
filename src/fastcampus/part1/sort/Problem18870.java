package fastcampus.part1.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 좌표 압축
 *
 * <p>https://www.acmicpc.net/problem/18870</p>
 *
 * <p>
 * 입력 값의 상대적인 순위를 압축된 좌표 값으로 변환하는 기법을 구현한 문제.
 * 좌표 압축은 값의 범위가 크고 불규칙할 때, 상대적 크기만 중요한 경우 주로 사용됩니다.
 * </p>
 *
 * <p>
 * <b>문제 해결 방안:</b>
 * <ul>
 *   <li>입력 값을 정렬하여 값의 순서를 결정 (중복 제거 포함).</li>
 *   <li>"정렬된 순서에 따라 0부터 번호를 부여"하여 매핑(Map)을 생성.</li>
 *   <li>원래 배열의 숫자를 매핑된 값으로 치환해 출력.</li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>시간 복잡도:</b>
 * <ul>
 *   <li>입력 정렬: O(N log N)</li>
 *   <li>매핑 생성 및 값 치환: O(N)</li>
 *   <li>총 시간 복잡도: O(N log N)</li>
 * </ul>
 * </p>
 */
public class Problem18870 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 입력 값의 개수
    int N = Integer.parseInt(br.readLine());
    String[] inputStrArr = br.readLine().split(" ");
    int[] inputArr = new int[N];

    // 입력값을 정수 배열로 변환
    for (int i = 0; i < N; i++) {
      inputArr[i] = Integer.parseInt(inputStrArr[i]);
    }

    // 배열 복사 및 정렬
    int[] sortedArr = inputArr.clone();
    Arrays.sort(sortedArr);

    // HashMap을 이용한 좌표 압축 매핑 생성
    Map<Integer, Integer> posMap = new HashMap<>();
    int idx = 0;

    for (int value : sortedArr) {
      // 이미 매핑되지 않은 값이라면 추가
      if (!posMap.containsKey(value)) {
        posMap.put(value, idx++);
      }
    }

    // 원래 입력 값 기준으로 좌표 압축된 값 출력
    for (int value : inputArr) {
      bw.write(posMap.get(value) + " ");
    }

    bw.flush();
  }

  /*
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String[] inputStrArr = br.readLine().split(" ");

    // 중복 제거
    Set<String> posSet = new HashSet<>();
    Collections.addAll(posSet, inputStrArr);

    // 숫자 정렬을 위한 변환 및 정렬
    int[] posArr = posSet.stream()
        .mapToInt(Integer::valueOf)
        .toArray();
    Arrays.sort(posArr);

    // 좌표 압축 매핑
    Map<String, Integer> posMap = new HashMap<>();
    for (int i = 0; i < posArr.length; i++) {
      posMap.put(String.valueOf(posArr[i]), i);
    }

    for (String inputStr : inputStrArr) {
      bw.write(posMap.get(inputStr) + " ");
    }

    bw.flush();
  }
  */
}

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String[] inputStrArr = br.readLine().split(" ");

    Set<String> posSet = new HashSet<>();
    Collections.addAll(posSet, inputStrArr);

    int[] posArr = posSet.stream()
        .mapToInt(Integer::valueOf)
        .toArray();
    Arrays.sort(posArr);

    Map<String, Integer> posMap = new HashMap<>();
    for (int i = 0; i < posArr.length; i++) {
      posMap.put(String.valueOf(posArr[i]), i);
    }

    for (String inputStr : inputStrArr) {
      bw.write(posMap.get(inputStr) + " ");
    }

    bw.flush();
  }
}
*/
