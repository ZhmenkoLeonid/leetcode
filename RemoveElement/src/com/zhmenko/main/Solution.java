package com.zhmenko.main;

import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int curPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[curPos] = nums[i];
                curPos++;
            }
        }
        return curPos;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int result = new Solution().removeElement(nums, val);
        System.out.println(Arrays.toString(nums));
        System.out.println(result);
    }
}