class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&& temperatures[i]>st.peek()[0]){
                    int[] curr = st.pop();
                    ans[curr[1]] = i-curr[1];
                    
                }
                st.push(new int[]{temperatures[i],i});
        }
        
        return ans;
    }
}