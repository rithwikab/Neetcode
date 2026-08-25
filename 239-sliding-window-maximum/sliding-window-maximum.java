class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> maxIndex = new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!maxIndex.isEmpty() && nums[maxIndex.getLast()] < nums[i]){
                maxIndex.pollLast();
            }
            maxIndex.offerLast(i);          
        }
        ans[0] = nums[maxIndex.getFirst()];
        for(int i=k;i<n;i++){
            while(!maxIndex.isEmpty() && maxIndex.getFirst() <= i-k){
                maxIndex.pollFirst();
            }
            while(!maxIndex.isEmpty() && nums[maxIndex.getLast()] < nums[i]){
                maxIndex.pollLast();
            }
            maxIndex.offerLast(i);
            ans[i-k+1]=nums[maxIndex.getFirst()];
        }
        return ans;
    }
}