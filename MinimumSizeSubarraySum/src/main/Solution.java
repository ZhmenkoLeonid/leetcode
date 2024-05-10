package main;

import java.util.Arrays;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curSum = 0;
            int curIndex = i;
            while (curIndex < nums.length && curSum < target) {
                curSum += nums[curIndex];
                curIndex++;
            }
            if (curSum >= target) {
                minLength = Math.min(minLength, curIndex - i);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        int result = new Solution().minSubArrayLen(target, nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(result);
    }
}