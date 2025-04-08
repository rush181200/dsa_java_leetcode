class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--)
            if(s.charAt(i)!='0') {
                dp[i]=dp[i+1];
                if(i<n-1&&(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7')) 
					dp[i]+=dp[i+2];
            }
        return dp[0];   

        // MemoIzation
        // Arrays.fill(dp, -1);
        // return decodeWays(0, s,dp);
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
