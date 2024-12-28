class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(char c:word.toCharArray()){
            if(c == ch && flag == false){
                sb.append(c);
                sb.reverse();
                flag = true;
            }else{
                sb.append(c);
            }
            
        }

        return sb.toString();
    }
}