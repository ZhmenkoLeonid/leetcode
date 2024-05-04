package com.zhmenko.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canJump(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        return jump (nums, 0, visited);
    }

    private boolean jump (int nums[], int pos, Set<Integer> visited) {
        if (pos == nums.length - 1) return true;
        visited.add(pos);
        for (int i = 1, newPos = pos+1; newPos < nums.length && i <= nums[pos]; i++, newPos++) {
            if (!visited.contains(newPos) && jump(nums,newPos, visited)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,0};
        int val = 2;
        boolean result = new Solution().canJump(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(result);
    }
}