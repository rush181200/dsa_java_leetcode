// mycode
class Solution {
    public int countPoints(String rings) {
        int n = rings.length();
        String[] arr = new String[10]; // There are only 10 possible rod indices: 0-9

        // Initialize all array elements to empty strings
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "";
        }

        for (int i = 0; i < n; i += 2) {
            char color = rings.charAt(i); // Get the color
            int index = rings.charAt(i + 1) - '0'; // Get the rod index
            arr[index] += color; // Append the color to the respective rod
        }

        // Count the rods that have all three colors (R, G, B)
        int count = 0;
        for (String s : arr) {
            if (s.contains("R") && s.contains("G") && s.contains("B")) {
                count++;
            }
        }

        return count;
    }
}


// Better code
// class Solution {
//     public int countPoints(String rings) {
//         int n = rings.length();
//         int[] rodColors = new int[10];
       
//         for(int i=0;i<n;i=i+2){
//            char color = rings.charAt(i);
//             int rod = rings.charAt(i + 1) - '0';
//             // Update the bitmask for the rod
//             if (color == 'R') {
//                 rodColors[rod] |= 1; // Set bit 0
//             } else if (color == 'G') {
//                 rodColors[rod] |= 2; // Set bit 1
//             } else if (color == 'B') {
//                 rodColors[rod] |= 4; // Set bit 2
//             }
//         }
//         int count = 0;
//         for (int mask : rodColors) {
//             if (mask == 7) { // 7 = binary 111, meaning all three bits are set
//                 count++;
//             }
//         }

//         return count;
//     }
// }