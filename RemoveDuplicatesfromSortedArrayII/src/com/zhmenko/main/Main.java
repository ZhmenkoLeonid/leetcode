package com.zhmenko.main;

import java.util.Arrays;

public class Main {
    public int removeDuplicates(int[] nums) {
        int elementsCnt = 0;
        int[] uniqueElements = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            uniqueElements[nums[i] + 10000]++;
        }
        for (int i = 0; i < uniqueElements.length; i++) {
                for (int j = 0; j < Math.min(uniqueElements[i],2); j++) {
                    nums[elementsCnt++] = i - 10000;
                }
        }
        return elementsCnt;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        Main solution = new Main();
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}