class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // Start from either step 0 or step 1
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        int startFrom0 = letsCount(cost, 0, dp);
        int startFrom1 = letsCount(cost, 1, dp);
        return Math.min(startFrom0, startFrom1);
    }

    public int letsCount(int[] cost, int index, int[] dp) {
        if (index >= cost.length) return 0;
        if(dp[index]!=-1) return dp[index];
        int oneStep = letsCount(cost, index + 1, dp);
        int twoStep = letsCount(cost, index + 2, dp);

        return dp[index] = cost[index] + Math.min(oneStep, twoStep);
    }
}
