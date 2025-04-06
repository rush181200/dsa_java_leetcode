class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // We can end at either the last or second last step
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}


// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         // Start from either step 0 or step 1
//         int[] dp = new int[cost.length+1];
//         Arrays.fill(dp,-1);
//         // int startFrom0 = letsCount(cost, 0, dp);
//         // int startFrom1 = letsCount(cost, 1, dp);
//         dp[0] = cost[0];
//         dp[1] = cost[1];

//         for(int i=2;i<cost.length-1;i++){
//             int oneStep = dp[i + 1];
//             int twoStep = dp[i + 2];
//             dp[i] = cost[i] + Math.min(oneStep, twoStep);
//         }

//         return dp[cost.length-2];
//     }

//     public int letsCount(int[] cost, int index, int[] dp) {
//         if (index >= cost.length) return 0;
//         if(dp[index]!=-1) return dp[index];
//         int oneStep = letsCount(cost, index + 1, dp);
//         int twoStep = letsCount(cost, index + 2, dp);

//         return dp[index] = cost[index] + Math.min(oneStep, twoStep);
//     }
// }
