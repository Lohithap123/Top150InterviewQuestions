class Solution {
    public static void searchPairs(int[] nums, int left, int target,  List<List<Integer>>triplets){
        int right = nums.length -1;
        while(left < right){
            int currSum = nums[left] + nums[right];
            if(currSum == target){
                triplets.add(Arrays.asList(-target, nums[left],nums[right]));
                left++;
                right--;
                while(left < right && nums[left] == nums[left-1]){
                    left++;
                }
                while(left < right && nums[right] == nums[right+1]){
                    right--;
                }
            }           
            else if(currSum < target){
                left++;
            }
            else{
                right--;
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i = 0 ; i < nums.length-2; ++i){
            if( i >0 && nums[i] == nums[i-1]){
                continue;
            }
            searchPairs(nums, i+1, -nums[i], triplets);
        }
        return triplets;
    }

}
