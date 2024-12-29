class Solution {
    public boolean areNumbersAscending(String s) {
        int curnum = 0; // Tracks the last number

    String[] words = s.split(" "); // Split the string into words
    for (String word : words) {
        // Check if the word is a number
        if (word.matches("\\d+")) {
            int num = Integer.parseInt(word); // Parse the number
            if (num <= curnum) {
                return false; // Return false if the numbers are not strictly ascending
            }
            curnum = num; // Update the current number
        }
    }

    return true; // All numbers are in ascending order
    }
}