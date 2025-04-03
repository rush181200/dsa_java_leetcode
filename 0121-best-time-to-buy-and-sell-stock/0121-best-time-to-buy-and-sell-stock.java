class Solution {
    public int maxProfit(int[] arr) {
        int maxP = 0;
        int n = arr.length-1;
        int l=0;
        int r=1;
        while(r<=n){
            if(arr[l]>=arr[r]){
                l=r;
            }else if(arr[r]>arr[l]){
                maxP = Math.max(maxP,arr[r]-arr[l]);
            }
            r++;
        }
        return maxP;
    }
}