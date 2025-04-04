class Solution {
    int cnt;
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
         Arrays.fill(dp, -1); // Initialize all to -1
        return recurClimb(n,0,dp);
    }

    public int recurClimb(int n, int currStairs, int[] dp){
        if(currStairs > n) return 0; // dont add
        if(currStairs == n){
            return 1;
        }
        if (dp[currStairs] != -1) return dp[currStairs];

        dp[currStairs] = recurClimb(n, currStairs + 1, dp) + recurClimb(n, currStairs + 2, dp);
        return dp[currStairs];
    }
}