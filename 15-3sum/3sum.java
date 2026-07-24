class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            int l=i+1,r=n-1;
            while(l<r){
                int sum = nums[l] + nums[r] + nums[i];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]) l++;
                }
                else if(sum < 0){
                    l++;
                }
                else{
                    r--;
                }
            }

        }
        return ans;
    }
}