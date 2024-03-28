// class Solution {
//     int min = Integer.MAX_VALUE;
//     public int minEatingSpeed(int[] piles, int h) {
//         int n = piles.length;
//         int res = 0;
//         int max = 0;
//         int l =1;
        
//         for(int i=0;i<n;i++){
//             max = Math.max(piles[i],max);
//         }
//         int [] k = new int[max] ;
        
      
//         while(l<max){
//             int m = (l+max)/2;
            
//         }
        
        
//         return min;
//     }
// //     public void binary(int[] nums,int target,int l,int r,int[]piles){
// //         int m = (l+r)/2;
// //         int tot = 0;
// //         if(l>r){
// //            return ; 
// //         } 
// //         for(int i=0;i<piles.length;i++){
// //             tot+=Math.ceil(piles[i]/m);
// //         }
// //         System.out.println(m);
// //         System.out.println(tot);
// //         // if(tot<=target){
// //         //     min = Math.min(min,nums[m]);
// //         //     binary(nums,target,l,m-1,piles);
// //         // }else{
// //         //     min = Math.min(min,nums[m]);
// //         //     binary(nums,target,m+1,r,piles);
// //         // }
        
// //     }
// }

class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        // Initalize the left and right boundaries
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int middle = (left + right) / 2;
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / middle)
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            // Check if middle is a workable speed, and cut the search space by half.
            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return right;
    }
}
