class Solution {
    public String firstPalindrome(String[] words) {
        for(String s : words){
            if(ispalinDrome(s)){
                return s;
            }
        }
        return "";
    }
    public boolean ispalinDrome(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}