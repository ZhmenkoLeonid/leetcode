import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void rotate(int[] nums, int k) {
        int arrLen = nums.length;
        k %= arrLen;
        if (k == 0) return;
        int gcd = gcd(k, arrLen);
        long lcm = k * (long) arrLen / gcd;

        for (int i = 0; i < gcd; i++) {
            int replacedNum = nums[i];
            int tempIndex = i;
            long stepCnt = lcm/k;
            while (stepCnt > 0) {
                int temp = nums[(tempIndex + k) % arrLen];
                nums[(tempIndex + k) % arrLen] = replacedNum;
                tempIndex = (tempIndex + k) % arrLen;
                replacedNum = temp;
                stepCnt--;
            }
        }
    }

    public static int gcd(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return number1 + number2;
        } else {
            int absNumber1 = Math.abs(number1);
            int absNumber2 = Math.abs(number2);
            int biggerValue = Math.max(absNumber1, absNumber2);
            int smallerValue = Math.min(absNumber1, absNumber2);
            return gcd(biggerValue % smallerValue, smallerValue);
        }
    }

    public static void main(String[] args) throws IOException {
        List<Integer> numList = new ArrayList<>();
        String[] split = Files.readString(Path.of("1.txt")).split(",");
        for (String s : split) {
            numList.add(Integer.parseInt(s));
        }
        int[] nums =  new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            nums[i] = numList.get(i);
        }
        int val = 54944;
        new Solution().rotate(nums, val);
        System.out.println(Arrays.toString(nums));
    }
}