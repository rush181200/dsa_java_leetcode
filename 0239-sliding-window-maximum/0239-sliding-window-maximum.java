class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peekFirst() < i - k + 1) q.pollFirst();
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) q.pollLast();
            q.offer(i);
            if (i >= k - 1) ans[j++] = nums[q.peekFirst()];
        }
        return ans;
    }
}


// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
        
//         Deque<Integer> q = new ArrayDeque<>();
//         ArrayList<Integer> ans = new ArrayList<>();
//         int l=0;
//         int r=0;
//         int n = nums.length;
        
//         while(r<n){
//             q.addFirst(nums[r]);
            
//         }

        
        
        
//         int n = nums.length;
//         ArrayList<Integer> ans = new ArrayList<>();
//         int l= 0;
//         // int max = 0;
//         for(int r=0;r<n;r++){
//             // if(l==r){
//             //     max = nums[r];
//             // }
//             // else{
//             //     max = Math.max(max,nums[r]);
//             // }
            
//             // System.out.println(max);
//             if(r-l+1==k){
//                 int max=Integer.MIN_VALUE;
//                 int l1=l;
//                 int r1=r;
//                 while(l1<=r1){
//                     max = Math.max(max,nums[l1]);
//                     l1++;
//                 }
                    
//                 ans.add(max);
//                 l++;
//             }
//         }
//         int[] arr = new int[ans.size()];
//         for (int i = 0; i < ans.size(); i++) {
//             arr[i] = ans.get(i);
//         }
//         return arr;
//     }
// }