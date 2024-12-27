class Solution {
    public int minTimeToType(String word) {
        int minTime = 0;
        char curr = 'a';
        
        for(char nword : word.toCharArray()){
            int clockwise = Math.abs(nword - curr);
            int counterClockwise = 26 - clockwise;
            System.out.println(clockwise);
            System.out.println(counterClockwise);
        
                 minTime += Math.min(clockwise, counterClockwise) + 1;

            // Update current character
            curr = nword;
           
        }


        return minTime;
    }
}