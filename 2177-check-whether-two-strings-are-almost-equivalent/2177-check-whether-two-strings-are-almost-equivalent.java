class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        if(word1.length()!=word2.length()) return false;
        int[] difference = new int[26];

        for(char c : word1.toCharArray()){
            difference[c-'a']++;
        }
        for(char c : word2.toCharArray()){
            difference[c-'a']--;
        }
        for(int i = 0;i<difference.length;i++){
            if(difference[i] > 3 || difference[i] < -3) return false;
        }
       
        return true;
    }
}