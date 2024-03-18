class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int[] minLR = new int[height.length];
        int n = height.length;
        int maxL = 0;
        int maxR = 0;
        int res =0;
        for(int i=0;i<n-1;i++){
            maxLeft[i] = Math.max(height[i],maxL);
            maxL = maxLeft[i];
        }
        for(int j=n-1;j>=0;j--){
            maxRight[j] = Math.max(height[j],maxR);
            maxR = maxRight[j];
        }
        for(int i=0;i<n-1;i++){
           minLR[i] = Math.min(maxLeft[i],maxRight[i]);
        }
        for(int i=0;i<n-1;i++){
          res += minLR[i]-height[i];
        }
        return res;
    }
}