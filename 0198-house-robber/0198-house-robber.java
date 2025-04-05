class Solution {
    public int maxMoney(int ind, int[] nums, int[] dp){
        if(ind == 0) return nums[0];
        if(ind<0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        return dp[ind] = Math.max(nums[ind]+maxMoney(ind-2,nums,dp),0+maxMoney(ind-1,nums,dp));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = maxMoney(n-1,nums,dp);
        return ans;
    }
}