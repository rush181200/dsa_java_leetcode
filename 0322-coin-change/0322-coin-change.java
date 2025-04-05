class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int result = helper(coins.length - 1, amount, coins, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int helper(int index, int remaining, int[] coins, int[][] dp) {
        // If we've reached 0 amount, 0 coins needed
        if (remaining == 0) return 0;

        // Invalid path
        if (index < 0 || remaining < 0) return Integer.MAX_VALUE;

        if (dp[index][remaining] != -1) return dp[index][remaining];

        // Option 1: take current coin (stay at index)
        int take = helper(index, remaining - coins[index], coins, dp);
        if (take != Integer.MAX_VALUE) take += 1; // valid path

        // Option 2: skip current coin
        int skip = helper(index - 1, remaining, coins, dp);

        dp[index][remaining] = Math.min(take, skip);
        return dp[index][remaining];
    }
}




// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int[] dp = new int[coins.length+1];
//         Arrays.fill(dp,-1);
//         int ans = helper(coins.length-1,0,0,coins,amount,dp);
//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }

//      public int helper(int index, int sum, int coinsUsed, int[] coins, int amount,int[] dp) {
//         if (sum == amount) return coinsUsed;
//         if (sum > amount || index < 0) return Integer.MAX_VALUE;
//         if(dp[index]!=-1) return dp[index];
//         // \U0001f3af Take the coin (stay at same index)
//         int take = helper(index, sum + coins[index], coinsUsed + 1,coins,amount,dp);

//         // \U0001f3af Skip the coin (move to smaller coin)
//         int skip = helper(index - 1, sum, coinsUsed,coins,amount,dp);

//         // Return the minimum number of coins from both choices
//         return dp[index] = Math.min(take, skip);
//     }
// }



       // Arrays.sort(coins);
        // int i = coins.length-1;
        // int count = 0;
        // while(i>0){
        //     while(amount>=coins[i]){
        //         amount = amount-coins[i];
        //         count++;
        //         if(amount==0) return count;
        //     }
        //     i--;
        // }
        // return -1;