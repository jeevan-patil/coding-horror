package xyz.jeevan.code.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] input = {2, 7, 11, 15};
    int target = 9;

    int[] output = new TwoSum().twoSum(input, target);
    for (int num : output) {
      System.out.print(num + "  ");
    }
  }

  public int[] twoSum(int[] input, int target) {
    Map<Integer, Integer> data = new HashMap<>();

    for (int i = 0; i < input.length; i++) {
      int complement = target - input[i];

      if (data.containsKey(complement)) {
        return new int[]{data.get(complement), i};
      }
      data.put(input[i], i);
    }

    throw new IllegalArgumentException("Not found.");
  }
}
