package doit.sort;

public class SelectionSort {

  public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int minIndex = i; // 현재 위치를 최소값 인덱스로 설정
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j; // 더 작은 값이 발견되면 최소값 인덱스 업데이트
        }
      }
      // Swap
      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp; // 현재 위치와 최소값 위치 교환
    }
  }

  public static void main(String[] args) {
    int[] arr = {5, 3, 8, 4, 2};
    selectionSort(arr);
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}
