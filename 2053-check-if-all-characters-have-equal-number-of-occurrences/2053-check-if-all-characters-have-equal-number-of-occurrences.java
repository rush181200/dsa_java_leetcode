class Solution {
    public boolean areOccurrencesEqual(String s) {
      int[] frequency = new int[26];
        
        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        
        // Store the frequency of the first character
        int firstFreq = frequency[s.charAt(0) - 'a'];
        
        // Check if all characters have the same frequency
        for (int i = 1; i < frequency.length; i++) {
            // Skip empty character slots
            if (frequency[i] != 0 && frequency[i] != firstFreq) {
                return false; // Frequencies are not equal
            }
        }
        
        return true;
    }
}