class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        boolean isZero = false;
        List<String> ans = new ArrayList<>();
        if(groups[0]==1 && isZero == false){
                ans.add(words[0]);
                isZero = false;
            }
        for(int i = 0;i<n;i++){
            if(groups[i]==0 && isZero == false){
                ans.add(words[i]);
                isZero = true;
            }else if(groups[i]==1 && isZero == true){
                ans.add(words[i]);
                isZero = false;
            }
        }
        return ans;
    }
}