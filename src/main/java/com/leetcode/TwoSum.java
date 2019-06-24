package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018/10/12 22:53
 */
public class TwoSum {

    public static void main(String[] args) {
        int [] a = {2, 11, 5, 7};
        int[] c = twoSum3(a,9);
        System.out.println(c);
    }

    public static int[] twoSum(int[] nums, int target) {
        int [] a = new int[2];
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length ; i++) {
            if(map.containsKey(target - nums[i])) {
                a [0] = nums[i];
                a [1] = map.get(target - nums[i]);
            } else {
                map.put(nums[i], i);
            }
        }
        return a;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] indices = new int[2];
        Map<Integer,Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                indices[0]=map.get(nums[i]);
                indices[1]=i;
                break;
            } else {
                map.put(target-nums[i],i);
            }
        }
        return indices;
    }

    public static int[] twoSum3(int[] nums, int target) {
        int pow2 =(int)Math.pow(2, 5), limit = pow2 / 2;
        short[] positions = new short[pow2];
        for(int aNum = 0; aNum < nums.length; aNum++) {
            int complement = target - nums[aNum], complPos = positions[(complement + limit)% pow2];
            if(complPos != 0) {
                return new int[] { complPos + Short.MAX_VALUE / 2, aNum };
            }
            positions[(nums[aNum] + limit)% pow2]=(short)(aNum - Short.MAX_VALUE / 2);
        }
        return null;
    }
}
