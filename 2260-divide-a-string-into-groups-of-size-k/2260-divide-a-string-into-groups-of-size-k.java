class Solution {
    public String[] divideString(String str, int size, char fill) {
        // if (str == null || size <= 0) {
        //     throw new IllegalArgumentException("Invalid input or chunk size.");
        // }

        List<String> result = new ArrayList<>();
        while (str.length() % size != 0) {
            str += fill;
        }

        for (int i = 0; i < str.length(); i += size) {
            result.add(str.substring(i, i + size));
        }
        String[] array = result.toArray(new String[0]);
        return array;
    }
}