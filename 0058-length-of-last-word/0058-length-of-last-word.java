class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        String[] str = s.split(" ");
        
        return str[str.length-1].length();
    }
}