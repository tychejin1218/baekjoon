package doit.sort;

public class InsertionSort {

  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i]; // 삽입될 요소
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j]; // 값을 한 칸 오른쪽으로 이동
        j--;
      }
      arr[j + 1] = key; // key를 정확한 위치에 삽입
    }
  }

  public static void main(String[] args) {
    int[] arr = {5, 3, 8, 4, 2};
    insertionSort(arr);
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}
