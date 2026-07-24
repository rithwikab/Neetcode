class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int i:nums){
            m.put(i,m.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> e:m.entrySet()){
            pq.add(new int[]{e.getKey(),e.getValue()});
            while(pq.size()>k)pq.poll();
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}