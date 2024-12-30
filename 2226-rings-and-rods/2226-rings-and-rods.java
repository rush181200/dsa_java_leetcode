class Solution {
    public int countPoints(String rings) {
        int n = rings.length();
        int[] rodColors = new int[10];
       
        for(int i=0;i<n;i=i+2){
           char color = rings.charAt(i);
            int rod = rings.charAt(i + 1) - '0';
            // Update the bitmask for the rod
            if (color == 'R') {
                rodColors[rod] |= 1; // Set bit 0
            } else if (color == 'G') {
                rodColors[rod] |= 2; // Set bit 1
            } else if (color == 'B') {
                rodColors[rod] |= 4; // Set bit 2
            }
        }
        int count = 0;
        for (int mask : rodColors) {
            if (mask == 7) { // 7 = binary 111, meaning all three bits are set
                count++;
            }
        }

        return count;
    }
}