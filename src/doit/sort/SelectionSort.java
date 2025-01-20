package doit.sort;

public class SelectionSort {

  public static void main(String[] args) {

    int[] arr = {5, 3, 8, 4, 2};
    selectionSort(arr);

    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  public static void selectionSort(int[] arr) {

    for (int i = 0; i < arr.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }

      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
    }
  }
}
