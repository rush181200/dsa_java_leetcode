class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        int[] temp = new int[n];
             for(int i=n-k;i<n;i++){
                 temp[i-(n-k)] = nums[i];
             }
            
             for(int i=n-k-1;i>=0;i--){

                 nums[i+k] = nums[i];
             }
        
            for(int i=0;i<k;i++){
                nums[i] = temp[i];
            }
        
        
        
        
        
// //      Not good   brute force
//         while(k>0){
// //             moving one element to right
//              int temp = nums[n-1];
//             for(int i=n-1;i>0;i--){
//                 nums[i] = nums[i-1];
//             }
//             nums[0] = temp;
//             k--;
//         }
//         left rotation
//         k=k%n;
//         int[] temp = new int[n-k];
//          for(int i=k;i>0;i--){
//              temp[i] = nums[i];
//          }
//         for(int i=0;i<k;i++){
//                System.out.println(temp[i]);
//             }
            
//          for(int i=k;i<n;i++){
//              nums[i-k] = nums[i];
//          }
        
//         for(int i = n-k;i<n;i++){
//             nums[i] = temp[i-(n-k)];
//         }   
        
        
    }
}