class Solution {
    public int getLucky(String s, int k) {
       String combine="";

        for(char c : s.toCharArray()){
            combine = combine + (c-'a'+1);
        }
    
       int ans = 0;
       System.out.println(combine);
       while(k>0){
       
        ans=0;
        for(int i=0;i<combine.length();i++){
            int digit = combine.charAt(i)-'0';
            
            ans+=digit;
        }
        
        combine = String.valueOf(ans);
        k--;
       }
         
   
       return ans;
    }
}