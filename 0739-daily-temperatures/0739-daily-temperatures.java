class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        int n = temperatures.length;
        int[] op = new int[n];
        
        for(int i=0;i<n;i++){
                while(!st.isEmpty() &&st.peek().getKey()<temperatures[i]){
                    int ind = st.pop().getValue();
                    op[ind] = i-ind;
            }
            st.push(new Pair(temperatures[i],i));
        }
        
        while(!st.isEmpty()){
            int ind =st.peek().getValue();
            op[ind] = 0;
            st.pop();
        }
        
        return op;
    }
}

// class Solution {

//     public int[] dailyTemperatures(int[] temperatures) {
//         int[] ans = new int[temperatures.length];
//         Stack<Integer> stack = new Stack<>();
//         for (int currDay = 0; currDay < temperatures.length; currDay++) {
//             while (
//                 !stack.isEmpty() &&
//                 temperatures[currDay] > temperatures[stack.peek()]
//             ) {
//                 int prevDay = stack.pop();
//                 ans[prevDay] = currDay - prevDay;
//             }
//             stack.add(currDay);
//         }
//         return ans;
//     }
// }
