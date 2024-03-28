// class Solution {
//     public int largestRectangleArea(int[] heights) {
        
//         int n = heights.length;
//         if(n==1){
//             return heights[0];
//         }
//         int max = 0;
//         int l=0;
       
//         Stack<Integer> st = new Stack<>();
        
//         for(int i=0;i<n;i++){
//             while(!st.isEmpty()&&st.peek()<heights[i]){
//                 int s = st.size();
//                 int mini = heights[i];
//                     mini = Math.min(mini,st.pop());
//                 int ans = mini * (s+1);
//                 max = Math.max(max,ans);
//             }
//             st.push(heights[i]);
//         }
//         int minin = Integer.MAX_VALUE;
//         while(!st.isEmpty()){
//             int s = st.size();
                
//              minin = Math.min(minin,st.pop());
//                 int ans = minin * (s);
//                 max = Math.max(max,ans);
//         }
        
        
//         // for(int i=0;i<n;i++){
//         //     int min = Integer.MAX_VALUE;
//         //     for(int j=i;j<n;j++){
//         //         min = Math.min(min,heights[j]);
//         //         int ans = (j-i+1)*min;
//         //         max = Math.max(ans,max);
//         //     }
//         // }
//         return max;
//     }
// }
class Solution {
    public int largestRectangleArea(int[] heights) {
      int area = 0, n = heights.length;
      int start;
      Stack<Pair<Integer,Integer>> stack = new Stack<>();
      for(int i=0;i<heights.length;i++){
         int curHt =heights[i];
         start = i;
        while(!stack.isEmpty() && stack.peek().getValue() > curHt){
          Pair<Integer,Integer> pair = stack.pop();
          int index = pair.getKey();
          int h = pair.getValue();
          area = Math.max(area, h * (i - index));
          start = index;
        }
        stack.push(new Pair(start,curHt));
      }
      
       while(!stack.isEmpty()){
          Pair<Integer,Integer> pair = stack.pop();
          int index = pair.getKey();
          int h = pair.getValue();
          area = Math.max(area, h * (n - index));
       }
        return area;
    }
  
}
