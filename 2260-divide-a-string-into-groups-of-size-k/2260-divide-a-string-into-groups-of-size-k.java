class Solution {
    public String[] divideString(String str, int size, char fill) {
        // Validate input
        if (str == null || size <= 0) {
            throw new IllegalArgumentException("Invalid input or chunk size.");
        }

        // List to store resulting chunks
        List<String> result = new ArrayList<>();

        // Calculate the number of characters to add (if needed) to make the length divisible by size
        int fillCount = (size - (str.length() % size)) % size;

        // Use StringBuilder to efficiently append fill characters if needed
        StringBuilder sb = new StringBuilder(str);
        while (fillCount > 0) {
            sb.append(fill);  // Append the fill character once to the StringBuilder
            fillCount--;
        }

        // Divide the string into chunks of the given size
        for (int i = 0; i < sb.length(); i += size) {
            result.add(sb.substring(i, i + size));  // Add substring of size 'size' to the list
        }

        // Convert the list to an array and return
        return result.toArray(new String[0]);
    }
}