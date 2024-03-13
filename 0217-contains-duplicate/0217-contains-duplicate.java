class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean ans = false;
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
               
//                 if(nums[i]==nums[j]){
                    
//                    return true;
//                 }
//             }
//         }
        int n = nums.length;
        Set<Integer> f = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            f.add(nums[i]);
        }
        if(f.size() != n) return true;
         return ans;
    }
}