class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
    
        s = s.trim();

        for(int i = s.length()-1;i>=0;i--){
            System.out.println(s.charAt(i));
            if(s.charAt(i)!=' '){
                ans++;
            }
            else if(ans>0){
                break;
            }
        }

        return ans;
        // String[] str = s.split(" ");
        // return str[str.length-1].length();
    }
}