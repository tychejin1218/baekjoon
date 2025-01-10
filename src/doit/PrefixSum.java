package doit;

public class PrefixSum {

  public static void main(String[] args) {

    int[] nums = {1, 2, 3, 4, 5};
    int[] prefixSum = new int[nums.length + 1];

    for (int i = 1; i <= nums.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
    }

    int left = 1, right = 3;
    int sum = prefixSum[right] - prefixSum[left - 1];
    System.out.println("구간 합: " + sum);
  }
}
