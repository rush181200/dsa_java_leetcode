class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove indices outside the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices whose values are less than current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Start recording max values once window is fully filled
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}


// 42/51 testcaes works then TIME LIMIT EXCEED
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//          if (nums == null || nums.length == 0 || k == 0 || k > nums.length) {
//             return new int[0];
//         }
//         int n = nums.length-1;
//         int l=0;
//         int r = l+k-1;
//         List<Integer> list = new ArrayList<>();
//         while(r<=n){
//             int max = nums[l];
//             for(int a = l;a<=r;a++){
//                 max = Math.max(max,nums[a]);
//             }
//             list.add(max);
//             l++;
//             r++;
//         }
//         return list.stream().mapToInt(i -> i).toArray();

//     }
// }