class Solution {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        int i = 0;
        for(int j=0;j<3;j++){
            int cur = freq[j];
            int end = i+cur;
            while(end <= nums.length && i<end){
                nums[i++] = j;
            }
        }

    }
}