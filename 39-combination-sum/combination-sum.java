class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        backtrack(0,n,candidates,target,new ArrayList<Integer>());
        return ans;
    }
    public void backtrack(int cur,int end,int[] nums,int target,List<Integer> curList){
        if(cur>= end || target < 0)return;
        if(target==0){
            ans.add(new ArrayList<Integer>(curList));
            return;
        }
        curList.add(nums[cur]);
        backtrack(cur,end,nums,target-nums[cur],curList);
        curList.remove(curList.size()-1);
        backtrack(cur+1,end,nums,target,curList);

        return;
    }
}