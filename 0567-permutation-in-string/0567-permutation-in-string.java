class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1count = new int[26];
        int[] s2count = new int[26];
       
        int count=s1.length();
        int matches=0;
        for(int i=0;i<26;i++){
            s1count[i]=0;
            s2count[i]=0;
        }
        
        for(int i=0;i<s1.length();i++){
            s1count[s1.charAt(i)-'a']++;
            
        }
        int left=0;
        int right=0;
        
       for(int i=0;i<s2.length();i++){
           s2count[s2.charAt(i)-'a']++;
           if(i>=count){
               s2count[s2.charAt(i-count)-'a']--;
           }
           if(Arrays.equals(s1count,s2count)){
               return true;
           }
       }
        
        return false;
    }
}