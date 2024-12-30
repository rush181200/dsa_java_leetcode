class Solution {
    public String convertToTitle(int columnNumber) {
        // int at_which = columnNumber%26;
        // int to_which = columnNumber/26 ;
        // System.out.println(at_which);
        // System.out.println(to_which);
        // String ans= "";
 
        // if(to_which!=0)ans+= (char)('A'+to_which-1);
        // ans+=(char)('A'+at_which-1);
        
        // return ans;
         StringBuilder ans = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Adjust to 0-based indexing
            int at_which = columnNumber % 26; // Find the current character
            ans.insert(0, (char)('A' + at_which)); // Prepend the character
            columnNumber /= 26; // Move to the next position
        }

        return ans.toString();
    }
}