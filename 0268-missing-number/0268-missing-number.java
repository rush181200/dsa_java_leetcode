// class Solution {
//     public int missingNumber(int[] nums) {
//         int answer = 0;
//         List<Integer> temp = new ArrayList<>();
        
//         for(int i=0;i<nums.length;i++){
//             temp.add(nums[i]);
//         }
        
//         for(int i=0;i<=nums.length;i++){
//             if(!temp.contains(i)) answer = i;
            
//         }
        
        
//         return answer;
//     }
// }

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = ans ^ i;
        }
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}