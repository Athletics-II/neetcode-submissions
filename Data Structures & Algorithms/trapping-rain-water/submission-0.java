class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1, res=0, left=height[l], right=height[r];
        while (l<r) {
            if (height[l] <= height[r]) {
                left=Math.max(left, height[l]);
                res+=left-height[l];
                l++;
            } else {
                right=Math.max(right, height[r]);
                res+=right-height[r];
                r--;
            }
        }
        return res;
        
    }
}
