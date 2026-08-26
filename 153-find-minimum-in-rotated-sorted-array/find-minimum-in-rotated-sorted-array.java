class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r= n-1;
        int min = Integer.MAX_VALUE;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[l] <= nums[r]){
                //total sorted
                min = Math.min(nums[l],min);
                break;
            }
            else if(nums[l] <= nums[mid]){
                //first half sorted
                min = Math.min(nums[l],min);
                l = mid +1;
            }
            else{
                //second half sorted
                min = Math.min(nums[mid],min);
                r = mid -1;
            }
            
        }
        return min;
    }
}