class Solution {
    public String capitalizeTitle(String title) {
        String[] s = title.split(" ");
        
        String ans = "";
        for(String s1:s){
          if(s1.length()>2) {
            ans += s1.substring(0, 1).toUpperCase();
          ans += s1.substring(1).toLowerCase();}else{
            ans += s1.toLowerCase();
          }
          ans += " ";
        }
        return ans.trim();
    }
}