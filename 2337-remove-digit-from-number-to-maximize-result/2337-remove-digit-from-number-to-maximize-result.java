class Solution {
    public String removeDigit(String s, char digit) {
         String result = "";
        int n = s.length();
       
        for(int i=0;i<n;i++){
            if(s.charAt(i)==digit){
                
                String curr = s.substring(0, i) + s.substring(i + 1);
                // Compare lexicographically to get the maximum
                if (result.isEmpty() || curr.compareTo(result) > 0) {
                    result = curr;
                }
            }
        }
        return result;
    }
}