class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = 1; 
        int length = nums.length; 

        while (nums[i] + nums[j] != target) { 
            j++; 
            if (j >= length) { 
                i++;
                j = i + 1;
            }
            if (i >= length) 
                break;
        }

        return new int[]{i, j}; 
    }
}
