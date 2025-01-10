package doit;

public class TwoPointer {

  public static void main(String[] args) {

    int[] nums = {1, 2, 3, 4, 5};
    int start = 0, end = 0, sum = 0, target = 7;

    while (end < nums.length) {
      sum += nums[end];

      while (sum > target) {
        sum -= nums[start++];
      }

      if (sum == target) {
        System.out.println("부분 배열: [" + start + ", " + end + "]");
        break;
      }
      end++;
    }
  }
}
