class Solution {
    public int rob(int[] nums) {
        int prev=0, curr=0;

        for (int num : nums) {
            int profit = Math.max(prev+num, curr);
            prev = curr;
            curr = profit;
        }
        return curr;
    }
}
