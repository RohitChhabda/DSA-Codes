package com.developerstalk.array;

//All test cases pass on Leetcode
public class RemoveDuplicateFromSortedArray {
	public int removeDuplicates(int[] nums) {
        int size = nums.length;
        int uniqueEltIndex = 0;
        
        int count = 0;
        for(int index = 0 ; index <size-1; index++){
            if(nums[index] != nums[index+1]){
                nums[uniqueEltIndex++] = nums[index];
                count++;
            }
        }
        // Adding condition for Last Element
        nums[uniqueEltIndex++] = nums[size - 1];
        count++;
        return count;
    }
}
