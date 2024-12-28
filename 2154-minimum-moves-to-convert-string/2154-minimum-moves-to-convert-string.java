// class Solution {
//     public int minimumMoves(String s) {
//         StringBuilder sb = new StringBuilder(s);
//         int cnt = 0;
//         boolean flag = false;
//         int checkIf4 = 0;
//         for(int i=0;i<sb.length();i++){
//             if(sb.charAt(i)=='X'){
//                 sb.setCharAt(i,'0');
                
//                 flag = true;
//             }
//             if(i%3==0) cnt++;
//             checkIf4++;
//             if(checkIf4==3) checkIf4 = 0;
//         }
//         if(!flag) cnt = 0;
//         if(checkIf4>0) cnt++;
//         return cnt;
//     }
// }
class Solution {
    public int minimumMoves(String s) {
        int cnt = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == 'X') {
                cnt++;  // Increment move count
                i += 3; // Skip the next two characters as they're part of the same move
            } else {
                i++; // Move to the next character
            }
        }

        return cnt;
    }
}
