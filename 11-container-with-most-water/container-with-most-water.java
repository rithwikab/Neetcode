class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int l=0,r=n-1;
        while(l<r){
            int water = (r-l);
            if(height[l] < height[r]){
                water *= height[l];
                l++;
            }
            else{
                water *= height[r];
                r--;
            }
            max = Math.max(water,max);
        }
        return max;
    }
}