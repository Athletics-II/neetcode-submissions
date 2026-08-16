class Solution {
    public int findKthLargest(int[] nums, int k) {
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for (int n : nums) {
            if (n<min) min=n;
            if (n>max) max=n;
        }

        int[] count = new int[max-min+1];
        for (int n : nums) {
            count[n-min]++;
        }

        for (int i=max-min; i>=0; i--) {
            k-=count[i];
            if (k<=0) return i+min;
        }

        return -1;
    }
}
