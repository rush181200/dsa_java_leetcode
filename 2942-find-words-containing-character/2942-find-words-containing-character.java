class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<String> s = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            s.add(words[i]);
        }
        
        for(int i=0;i<s.size();i++){
            if(s.get(i).indexOf(x)!=-1){
                res.add(i);
            }
        }
        
        return res;
    }
}