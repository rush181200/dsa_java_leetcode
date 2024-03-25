class Solution {
    public boolean isNotValidNumber(String s) {
        try {
            Double.parseDouble(s); // or Integer.parseInt(s) for integer check
            return false; // If no exception is thrown, it's a valid number
        } catch (NumberFormatException e) {
            return true; // If an exception is thrown, it's not a valid number
        }
    }
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
       
        
        for(int i=0;i<tokens.length;i++){
            
            if(isNotValidNumber(tokens[i])){
               
               
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
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
       
        return st.peek();
    }
}