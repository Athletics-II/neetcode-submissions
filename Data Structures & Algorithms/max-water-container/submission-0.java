class Solution {
    public int maxArea(int[] heights) {
        int l=0, r=heights.length-1, max=0;
        while (l <  r) {
            if (heights[l] <= heights[r]) {
                max = Math.max(max, (r-l)*heights[l]);
                l++;
            } else {
                max = Math.max(max, (r-l)*heights[r]);
                r--;
            }
        }
        return max;
    }
}
