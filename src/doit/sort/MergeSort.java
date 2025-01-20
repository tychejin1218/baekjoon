package doit.sort;

public class MergeSort {

  public static void main(String[] args) {

    int[] arr = {5, 3, 8, 4, 2};
    mergeSort(arr, 0, arr.length - 1);

    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  public static void mergeSort(int[] arr, int left, int right) {

    if (left < right) {
      int mid = (left + right) / 2;

      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);

      merge(arr, left, mid, right);
    }
  }

  public static void merge(int[] arr, int left, int mid, int right) {

    int[] tempArr = new int[right - left + 1];
    int i = left;
    int j = mid + 1;
    int k = 0;

    while (i <= mid && j <= right) {
      if (arr[i] <= arr[j]) {
        tempArr[k++] = arr[i++];
      } else {
        tempArr[k++] = arr[j++];
      }
    }

    while (i <= mid) {
      tempArr[k++] = arr[i++];
    }

    while (j <= right) {
      tempArr[k++] = arr[j++];
    }

    for (int idx = 0; idx < tempArr.length; idx++) {
      arr[left + idx] = tempArr[idx];
    }
  }
}
