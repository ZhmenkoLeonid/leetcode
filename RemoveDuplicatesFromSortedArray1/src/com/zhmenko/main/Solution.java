package com.zhmenko.main;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int uniqueElementsCnt = 0;
        int[] uniqueElements = new int[201];
        for (int num : nums) {
            uniqueElements[num + 100]++;
        }
        for (int i = 0; i < uniqueElements.length; i++) {
            if (uniqueElements[i] > 0) {
                nums[uniqueElementsCnt++] = i - 100;
            }
        }
        return uniqueElementsCnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}