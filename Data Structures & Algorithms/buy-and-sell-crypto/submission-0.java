class Solution {
    public int maxProfit(int[] prices) {
        int curr=prices[0], max=0;
        for (int i=1; i<prices.length; i++) {
            max = Math.max(max, prices[i]-curr);
            curr = Math.min(curr, prices[i]);
        }
        return max;
    }
}
