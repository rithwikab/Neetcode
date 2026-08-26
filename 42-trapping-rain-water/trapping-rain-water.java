class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r=n-1, maxLeft = 0,maxRight =0,water =0;
        while(l<=r){
            if(height[l] <= height[r]){
                // process left
                if(height[l] > maxLeft)maxLeft = height[l];
                else water += maxLeft - height[l];
                l++;
            }
            else{
                //process right
                if(height[r] > maxRight) maxRight = height[r];
                else water+= maxRight - height[r];
                r--;
            }
        }
        return water;
    }
}