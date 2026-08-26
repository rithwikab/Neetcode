class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        //traverse the smaller array
        int l = 0, r = m;
        while(l<=r){
            // p1 -> NO.OF ELEMENTS IN FIRST PART OF THE MERGED ARRAY FROM NUMS1
            // p2 -> NO.OF ELEMENTS IN FIRST PART OF THE MERGED ARRAY FROM NUMS1
            int p1 = (l+r)/2;
            int p2 = (m+n+1)/2-p1;
            int left1 = (p1==0)?Integer.MIN_VALUE:nums1[p1-1];
            int left2 = (p2==0)?Integer.MIN_VALUE:nums2[p2-1];
            int right1 = (p1==m)?Integer.MAX_VALUE:nums1[p1];
            int right2 = (p2==n)?Integer.MAX_VALUE:nums2[p2];

            if(left1 <= right2 && left2<=right1){
                if((m+n)%2==0){
                    return ((Math.max(left1,left2)+Math.min(right1,right2))/2.00);
                }
                else{
                    return Math.max(left1,left2);
                }
            }

            else if(left1>right2){
                //p1 should be reduced
                r = p1 -1;
            }
            else{
                l = p1+1;
            }

        }
        return 0.00;
    }
}