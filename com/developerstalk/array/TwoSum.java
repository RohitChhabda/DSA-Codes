package com.developerstalk.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] output = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            Integer val = target - nums[i];
            if(map.containsKey(val)){
                output[0] = map.get(val);
                output[1] =i;
                return output;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return output;
    }
}