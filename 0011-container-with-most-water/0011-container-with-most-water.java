class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i =0;
        int j = n-1;
        int ans = 0;

        while(i<j){
            int a = (j-i)*Math.min(height[i],height[j]);
            ans = Math.max(ans,a);
            if(height[i]<=height[j]){
                i++;
            }else{
                j--;
            }
        }

        return ans;
    }
}