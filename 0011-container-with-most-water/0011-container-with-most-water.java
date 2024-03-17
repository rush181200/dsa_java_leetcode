class Solution {
    public int maxArea(int[] height) {
        int maxStore = 0;
        int i =0;
        int j =height.length-1;
        while(i<=j){
            int cal = (j-i)*Math.min(height[i],height[j]);
            maxStore = Math.max(maxStore,cal);
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return maxStore;
    }
}