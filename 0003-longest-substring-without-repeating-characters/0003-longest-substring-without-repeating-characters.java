class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int left=0;
        int right=0;
        int n = s.length();
        int maxlen =0;
        
        while(right<n){
            while(hs.contains(s.charAt(right))&&left<right){
                hs.remove(s.charAt(left));
                left+=1;
            }
            hs.add(s.charAt(right));
            maxlen = Math.max(maxlen,right-left+1);
            right++;
        }
        return maxlen;
            
//         int llen = 0;
//         int left=0;
//         int right=0;
//         int n = s.length();
//         ArrayList<Character> map = new ArrayList<>();
        
        
//         while(right<n){
//             char ch = s.charAt(right);
            
        
//            if(map.contains(s.charAt(right) )&& left<=right){
//                llen += Math.max(llen,map.size());
               
//                     map.remove(s.charAt(left));
//                     left++;
//            }  
//                if(right<n){
//                      map.add(s.charAt(right));
//                      right++;
//                }
 
            
            
//         }
//         return llen;
    }
}