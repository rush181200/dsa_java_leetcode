class Solution {

    //sliding window
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int matched = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char right = s.charAt(endWindow);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()) {
                if (minLen > endWindow - start + 1) {
                    minLen = endWindow - start + 1;
                    subStr = start;
                }
                char deleted = s.charAt(start++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }
}


// class Solution {
//     public String minWindow(String s, String t) {
//         if(t.isEmpty()){
//             return "";
//         }
        
//         HashMap<Character,Integer> countT = new HashMap<>();
//         HashMap<Character,Integer> window = new HashMap<>();
//         int l=0;
//         int r=0;
//         int have=0;
        
//         int[] res = new int[2];
//         int resLen=Integer.MIN_VALUE;
        
//         for(char c:t.toCharArray()){
//             if(countT.containsKey(c)){
//                 int tot = countT.get(c);
//                 countT.put(c,tot+1);
//             }else{
//                 countT.put(c,1);
               
//             }
//         }
//         int need=countT.size();
        
//         for(r=0;r<s.length();r++){
//             char ch = s.charAt(r);
//              if(window.containsKey(ch)){
//                 int tot = window.get(ch);
//                 window.put(ch,tot+1);
//             }else{
//                 window.put(ch,1);
//             }
            
//             if(countT.containsKey(ch) && window.get(ch)==countT.get(ch)){
//                 have+=1;
//                 while(have==need){
//                     if((r-l+1)<resLen){
//                         res[0]=l;
//                         res[1]=r;
//                         resLen=r-l+1;
//                     }
                     
//                     char v = s.charAt(l); // Get the character at index l
        
//                 // Decrement the value associated with the character
//                 if (window.containsKey(v)) {
//                     int value = window.get(v); // Get the current value
//                     value--; // Decrement the value
//                     window.put(v, value); // Put the updated value back into the HashMap
//                 } 
//                  if (countT.containsKey(s.charAt(l)) && window.get(s.charAt(l)) == countT.get(s.charAt(l))){
//                      have-=1;
//                  }
//                 }        
//                     l+=1;
//             }
//         }
        
//          if(resLen!=Integer.MIN_VALUE){
//                return s.substring(l,r+1);
//             }
        
        
        
//         return "";   
//     }
        
// }