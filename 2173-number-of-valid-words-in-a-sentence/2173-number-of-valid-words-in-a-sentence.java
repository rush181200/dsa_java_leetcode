class Solution {
    public int countValidWords(String sentence) {
        String[] tokens = sentence.trim().split("\\s+"); // Split by spaces
        int validCount = 0;

        for (String token : tokens) {
            if (isValidWord(token)) {
                validCount++;
            }
        }
        
        return validCount;
    }

    private boolean isValidWord(String token) {
        if (token.isEmpty()) {
            return false;
        }
        
        boolean hasHyphen = false;
        boolean hasPunctuation = false;
        int n = token.length();

        for (int i = 0; i < n; i++) {
            char c = token.charAt(i);

            // Rule 1: No digits allowed
            if (Character.isDigit(c)) {
                return false;
            }

            // Rule 2: Hyphen rules
            if (c == '-') {
                if (hasHyphen || i == 0 || i == n - 1 || !Character.isLowerCase(token.charAt(i - 1)) || !Character.isLowerCase(token.charAt(i + 1))) {
                    return false;
                }
                hasHyphen = true;
            }

            // Rule 3: Punctuation rules
            if (c == '!' || c == '.' || c == ',') {
                if (hasPunctuation || i != n - 1) {
                    return false;
                }
                hasPunctuation = true;
            }

            // Rule 4: Only lowercase letters, hyphens, or punctuation allowed
            if (!Character.isLowerCase(c) && c != '-' && c != '!' && c != '.' && c != ',') {
                return false;
            }
        }

        return true;
    }
}
