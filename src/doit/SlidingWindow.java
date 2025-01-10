package doit;

public class SlidingWindow {

  public static void main(String[] args) {

    int[] nums = {2, 1, 5, 1, 3, 2};
    int k = 3, maxSum = 0, windowSum = 0;

    for (int i = 0; i < k; i++) {
      windowSum += nums[i];
    }
    maxSum = windowSum;

    for (int i = k; i < nums.length; i++) {
      windowSum += nums[i] - nums[i - k];
      maxSum = Math.max(maxSum, windowSum);
    }

    System.out.println("최대 윈도우 합: " + maxSum);
  }
}
