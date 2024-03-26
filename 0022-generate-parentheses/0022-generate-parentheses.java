// class Solution {
//     public List<String> generateParenthesis(int n) {
//         Stack<String> s = new Stack<>();
//         List<String> ans = new ArrayList<>();
//         int openN = 0;
//         int closeN = 0;
//         backtrack(openN,closeN,s,n,ans);
        
//         return ans;
        
//     }
    
//     public void backtrack(int open,int close,Stack<String> stack,int n,List<String> ans){
//         if(open==close && open==n && close==n){
//             ans.add(stack.pop());
//             return;
//         }
        
//         if(open<n){
//             stack.push("(");
//             backtrack(open+1,close,stack,n,ans);
//             stack.pop();
//         }
        
//         if(close<open){
//             stack.push(")");
//             backtrack(open,close+1,stack,n,ans);
//             stack.pop();
//         }
//     }
// }

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.generateParenthesis(3);
    }

    Stack<Character> stack = new Stack<>();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }

    private void backtrack(int openN, int closedN, int n) {
        if (openN == closedN && closedN == n) {
            Iterator vale = stack.iterator();
            String temp = "";
            while (vale.hasNext()) {
                temp = temp + vale.next();
            }
            res.add(temp);
        }
        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closedN, n);
            stack.pop();
        }
        if (closedN < openN) {
            stack.push(')');
            backtrack(openN, closedN + 1, n);
            stack.pop();
        }
    }
}
