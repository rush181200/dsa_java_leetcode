class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int n = 0;
        for(String s:patterns){
            if(word.contains(s)){
                n++;
            }
        }
        return n;
    }
}