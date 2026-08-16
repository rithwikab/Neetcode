class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c:tasks){
            freq[c-'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int batches = maxFreq - 1;
        int idleSlots = batches * n;
        for(int i=24;i>=0 && freq[i]>0; i--){
            idleSlots -= Math.min(batches,freq[i]);
        }
        idleSlots = Math.max(idleSlots,0);
        return tasks.length+idleSlots;
    }
}