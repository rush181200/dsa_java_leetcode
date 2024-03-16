class Solution {
    public boolean isPalindrome(String s) {
        String regex = "[^a-zA-Z0-9\\s]";
        int n = s.length();
        
        String rs = s.replaceAll(regex, "").replaceAll(" ","").toLowerCase();
        System.out.println(rs);
        int i=0;
        int j=rs.length()-1;
        System.out.println(i + " "+j);
        while(i<=j){
            if(rs.charAt(i)!=rs.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}