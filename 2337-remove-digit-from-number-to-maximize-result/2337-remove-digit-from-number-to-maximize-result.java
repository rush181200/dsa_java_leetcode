class Solution {
    public String removeDigit(String s, char digit) {
         String result = "";
        int n = s.length();
       
        for(int i=0;i<n;i++){
            if(s.charAt(i)==digit){
                // if(i==0){
                //    curr = s.substring(i+1);
                // }else if(i==n-1){
                //     curr = s.substring(0,n-1);
                // }else{
                //     curr = s.substring(0,i-1)+s.substring(i+1,n);
                // }
                // maxi = Math.max(maxi,Integer.parseInt(curr));
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