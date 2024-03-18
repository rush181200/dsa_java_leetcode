class Solution {
    public int maxProfit(int[] prices) {
        // Brute Force
        // int maxPro=0;
        // int n = prices.length;
        // for(int i=0;i<=n-2;i++){
        //     for(int j=i+1;j<=n-1;j++){
        //         if(prices[i]<prices[j]){
        //             int maxP = prices[j]-prices[i];
        //             maxPro = Math.max(maxPro,maxP);
        //         }
        //     }
        // }
        // return maxPro;
        int maxPro=0;
        int n = prices.length;
        int l = 0;
        int r = l+1;
        
        while(r<n){
            if(prices[r]>prices[l]){
                int profit = prices[r]-prices[l];
                 maxPro = Math.max(maxPro,profit);
                r++;
            }else{
                l=r;
                r++;
            }
        }
        return maxPro;
    }
}