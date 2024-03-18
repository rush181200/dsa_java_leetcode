class Solution {
    public int trap(int[] height) {
      int n = height.length;
        int l =0;
        int r = n-1;
        int maxL = height[l];
        int maxR = height[r];
        int res=0;
        
        while(l<r){
            if(maxL<maxR){
                l+=1;
                maxL = Math.max(maxL,height[l]);
                res += maxL-height[l];
            }else{
                r-=1;
                maxR = Math.max(maxR,height[r]);
                res += maxR-height[r];
            }
            
        }
        return res;  
    }
}