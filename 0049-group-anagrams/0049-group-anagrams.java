class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>()); 
            }
            map.get(sortedStr).add(str); // Now adding the word to the list
        }

        for (List<String> value : map.values()) {
            ans.add(value);
        }
        return ans;
    }
}