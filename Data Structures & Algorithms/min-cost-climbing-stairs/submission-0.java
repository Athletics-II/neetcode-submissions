class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length==0) return 0;
        if (cost.length==1) return cost[0];
        if (cost.length==2) return Math.min(cost[0], cost[1]);
        int dest = cost.length;
        int[] dp = new int[dest+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = Math.min(cost[0], cost[1]);
        //dp[3] = Math.min(cost[0]+cost[2], cost[1]);
        for (int i=3; i<=dest; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        return dp[dest];

    }
}
