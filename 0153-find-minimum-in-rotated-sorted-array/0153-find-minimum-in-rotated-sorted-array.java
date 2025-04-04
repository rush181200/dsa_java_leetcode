// class Solution {
//     public int findMin(int[] nums) {
//         int n = nums.length;
//         int r = n-1;
//         int l=0;
//         while(l<=r){
//             int mid = l+(r-l)/2;
//             if(nums[mid]>nums[r]){
//                 l = mid+1;
//             }else {
//                 r= mid;
//            }
//         }
//         return nums[l];
//     }
// }

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            // If mid element is greater than right, min must be on the right
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                // mid might be the smallest, so include it
                r = mid;
            }
        }

        return nums[l]; // or nums[r] — both are same when loop ends
    }
}
