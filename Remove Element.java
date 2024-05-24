class Solution {
    public int removeElement(int[] nums, int val) {
        int c=0;
        int n = nums.length;
        if(n==0){
            return 0;
        }
        for(int i=0;i<n;i++){
            if(nums[i]==val){
                c++;
            }
        }
        int m = n-c;
        int i=0,j=n-1;
        while(i<=j){
            if(nums[i]==val){
                if(nums[j]!=val){
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
                j--;
            }else{
                i++;
            }
        }
        return m;
    }
}
