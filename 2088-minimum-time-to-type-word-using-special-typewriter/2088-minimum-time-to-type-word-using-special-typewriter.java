class Solution {
    public int minTimeToType(String word) {
        int minTime = 0;
        char curr = 'a';
        
        for(char nword : word.toCharArray()){
            int clockwise = Math.abs(nword - curr);
            int counterClockwise = 26 - clockwise;
        
            minTime += Math.min(clockwise, counterClockwise) + 1;

            curr = nword;
           
        }


        return minTime;
    }
}