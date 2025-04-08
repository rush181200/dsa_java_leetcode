class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decodeWays(0, s,dp);
    }

    public int decodeWays(int index, String s,int[] dp) {
        // ✅ Base case: reached end of string
        if (index == s.length()) return 1;

        // ❌ Invalid if starts with '0'
        if (s.charAt(index) == '0') return 0;

        if(dp[index]!=-1) return dp[index];

        // Option 1: Take one digit
        int count = decodeWays(index + 1, s,dp);

        // Option 2: Take two digits if valid
        if (index + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                count += decodeWays(index + 2, s,dp);
            }
        }

        return dp[index]=count;
    }
}
