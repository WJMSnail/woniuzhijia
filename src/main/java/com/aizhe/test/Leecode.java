package com.aizhe.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName leecode
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/2/25 23:32
 */
public class Leecode {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int[] ints = new Leecode().twoSum2(new int[]{2, 4, 5, 6, 3}, 8);
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

}
