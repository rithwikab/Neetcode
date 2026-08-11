class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(0,nums.length,nums,new ArrayList<Integer>());
        return ans;
    }
    public void backtrack(int cur,int end,int[] nums,List<Integer> curList){
        if(cur==end){
            ans.add(new ArrayList<Integer>(curList));
            return;
        }
        for(int i=0;i<end;i++){
            if(curList.contains(nums[i]))continue;
            curList.add(nums[i]);
            backtrack(cur+1,end,nums,curList);
            curList.remove(curList.size()-1);
        }
        return;
    }
}