class Solution {
   
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
       
        
        for(int i=0;i<tokens.length;i++){
            
           
               
               
                if(tokens[i].equals("+")){
                   
                    if(!st.isEmpty()){
                        int b = st.pop();
                        int a = st.pop();
                        int c = b+a;
                        st.push(c);  
                    }
                
                }else if(tokens[i].equals("-")){
                    
                    if(!st.isEmpty()){
                        int b = st.pop();
                        int a = st.pop();
                        int c = a-b;
                        st.push(c);  
                    }
                    
                }else if(tokens[i].equals("*")){
                    
                     if(!st.isEmpty()){
                        int b = st.pop();
                        int a = st.pop();
                        int c = b*a;
                        st.push(c);  
                    }
                    
                }else if(tokens[i].equals("/")){
                    
                    if(!st.isEmpty()){
                        int b = st.pop();
                        int a = st.pop();
                        
                        int c = a/b;
                        st.push(c);  
                    }
                }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
       
        return st.peek();
    }
}

// class Solution {

//     public int evalRPN(String[] tokens) {
//         Stack<Integer> stack = new Stack<>();
//         for (String token : tokens) {
//             if (token.equals("+")) {
//                 stack.add(stack.pop() + stack.pop());
//             } else if (token.equals("-")) {
//                 int a = stack.pop();
//                 int b = stack.pop();
//                 stack.add(b - a);
//             } else if (token.equals("*")) {
//                 stack.add(stack.pop() * stack.pop());
//             } else if (token.equals("/")) {
//                 int a = stack.pop();
//                 int b = stack.pop();
//                 stack.add(b / a);
//             } else {
//                 stack.add(Integer.parseInt(token));
//             }
//         }
//         return stack.pop();
//     }
// }
