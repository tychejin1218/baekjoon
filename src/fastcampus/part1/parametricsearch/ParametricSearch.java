package fastcampus.part1.parametricsearch;

import java.util.Arrays;

public class ParametricSearch {

  public static void main(String[] args) {
    int[] machines = {2, 3, 7}; // 각 기계의 작업 완료 시간
    int tasks = 10;            // 총 작업 개수

    long minimumTime = findMinimumTime(machines, tasks);
    System.out.println("최소 시간: " + minimumTime);
  }

  // 최소 작업 시간을 구하는 Parametric Search 메서드
  public static long findMinimumTime(int[] machines, long tasks) {
    long low = 1; // 최소 시간
    long high = (long) Arrays.stream(machines).min().orElse(1) * tasks; // 최대 예상 시간
    long result = high; // 최적의 최소 시간을 저장할 변수

    while (low <= high) {
      long mid = (low + high) / 2;

      if (canCompleteTasks(mid, machines, tasks)) { // 중간 시간으로 작업 가능 여부 확인
        result = mid;   // 작업 가능하면 해당 시간을 결과에 저장
        high = mid - 1; // 더 짧은 시간 탐색
      } else {
        low = mid + 1;  // 더 긴 시간 탐색
      }
    }

    return result; // 최적의 최소 시간 반환
  }

  // 결정 함수: 주어진 시간에 작업을 모두 완료할 수 있는지 확인
  public static boolean canCompleteTasks(long time, int[] machines, long tasks) {
    long totalTasks = 0;
    for (int machine : machines) {
      totalTasks += time / machine; // 기계가 처리할 수 있는 작업량 계산
      if (totalTasks >= tasks) {   // 목표 작업량에 도달하면 바로 true 반환
        return true;
      }
    }
    return totalTasks >= tasks; // 전체 작업량 확인
  }
}
