class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0,nums.length,nums, new ArrayList<Integer>());
        return ans;
    }
    public void backtrack(int cur,int end,int[] nums, List<Integer> curList){
        if(cur == end){
            ans.add(new ArrayList<Integer>(curList));
            return;
        }
        curList.add(nums[cur]);
        backtrack(cur+1,end,nums,curList);
        curList.remove(curList.size()-1);
        backtrack(cur+1,end,nums,curList);
        return;
    }

}