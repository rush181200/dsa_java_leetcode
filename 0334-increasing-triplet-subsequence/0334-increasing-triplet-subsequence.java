class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i=Integer.MAX_VALUE;
        int j=Integer.MAX_VALUE;
        int k=0;
        int n=nums.length;
        if (nums == null || nums.length < 3)
            return false;
        
        for(int a=0;a<n;a++){
           if(i>=nums[a]){
             i = nums[a];   
           }else if(j>=nums[a]){
               j=nums[a];
           }else {
               return true;
           } 
            
        }
        
        return false;
    }
}