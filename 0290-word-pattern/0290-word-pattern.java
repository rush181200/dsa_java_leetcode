class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> st = new HashMap<>();
        String[] val = s.split(" ");
        // Check if lengths match
        if (pattern.length() != val.length) {
            return false;
        }
        int n = pattern.length();
        for(int i=0;i<n;i++){
            //     if(st.containsKey(pattern.charAt(i)))
            //     if(!st.get(pattern.charAt(i)).equals(val[i])){
            //         flag = false;
            //     }
            // if(!st.containsValue(val[i]));
            // st.put(pattern.charAt(i),val[i]);
             char currentChar = pattern.charAt(i);
            String currentWord = val[i];
            
            // Check if the character is already mapped
            if (st.containsKey(currentChar)) {
                if (!st.get(currentChar).equals(currentWord)) {
                    return false; // Mapping mismatch
                }
            } else {
                // Check if the word is already mapped to a different character
                if (st.containsValue(currentWord)) {
                    return false; // One-to-one mapping violation
                }
                st.put(currentChar, currentWord); // Add the new mapping
            }
        }
        return true;
    }
}