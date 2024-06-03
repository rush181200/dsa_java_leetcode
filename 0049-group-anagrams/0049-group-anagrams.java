// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, List<String>> res = new HashMap<>();
//         for(String s : strs){
//             int[] count = new int[26];
//             for(char c : s.toCharArray()){
//                 count[c-'a']++;
//             }
//             StringBuilder sb = new StringBuilder();
//             for (int i = 0; i < 26; i++) {
//                 sb.append('#');
//                 sb.append(count[i]);
//             }
            
//             String key = sb.toString();
            
//             if(!res.containsKey(key)){
//                 res.put(key, new ArrayList<>());
//             }
//             res.get(key).add(s);
            
            
//         }
//         return new ArrayList<>(res.values());
//     }
// }

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map=new HashMap<>();

        List<List<String>> result = new ArrayList<>();


        for (String word: strs) {
            char[] charArray = word.toCharArray();


            Arrays.sort(charArray);

            String sortedWord = String.valueOf(charArray);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }


            map.get(sortedWord).add(word);


        }
        result.addAll(map.values());

        return result;
    }
}