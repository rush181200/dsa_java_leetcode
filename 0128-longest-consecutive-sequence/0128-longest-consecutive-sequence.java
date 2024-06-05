class Solution {
    public int longestConsecutive(int[] nums) {
       
       
        if (nums.length == 0) return 0;
       HashSet<Integer> hs = new HashSet<>();
       for(int num:nums) hs.add(num);
         int longest = 0;
       for(int num: nums ){
           //check if the num is the start of a sequence by checking if left exists
           if(!hs.contains(num-1)){ // start of a sequence
                int count =1;
                while(hs.contains(num + 1)){ // check if hs contains next no.
                    num++;
                    count++;
                }
                longest = Math.max(longest, count);
                
           }
           if(longest > nums.length/2) break;
           // If the condition is true, it means that the length of the longest consecutive sequence found so far is greater than half the length of the array. In such a case, there's no need to continue iterating through the array because it's highly unlikely that a longer consecutive sequence will be found. Therefore, the break statement is used to exit the loop early, improving efficiency.
       }
        return longest;
    }
}