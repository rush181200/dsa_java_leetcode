class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxPile = 0;
        for(int i=0;i<n;i++){
            maxPile = Math.max(maxPile,piles[i]);
        }

       int l = 1;
       int r = maxPile;
       int k = 0;
       while(l<=r){
        int mid = l + (r - l) / 2;
        if(totalh(mid,piles)>h){
            
            l=mid+1;
        }else{
            k = mid;
            r=mid-1;
        }
       }
       return k;
    }

    public int totalh(int mid, int[]piles){
        int cnt = 0;
        for(int i=0;i<piles.length;i++){
            if(mid>=piles[i]) cnt++;
            else {
                cnt += Math.ceil((double)piles[i] / mid);

            }
        }
        System.out.println(cnt);
        return cnt;
    }
}