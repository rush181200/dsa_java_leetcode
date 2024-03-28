class Solution {
    boolean res = false;
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
           binary(matrix[i],target,0,matrix[i].length-1);
        }
        return res;
    }
    
    public void binary(int[] nums,int target,int l,int r){
        int m = (l+r)/2;
        if(l>r) return;
        if(nums[m]==target){
            res = true;
        } 
        
        if(nums[m]>target) binary(nums,target,l,m-1);
        else binary(nums,target,m+1,r);
    }
}