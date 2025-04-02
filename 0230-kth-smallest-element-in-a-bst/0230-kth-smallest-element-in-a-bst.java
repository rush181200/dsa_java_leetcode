// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//         dfs(root,k,maxHeap);
//         // further optimization but it fails when k=2 and one is on right [1, null, 2] because we are checking for left
//         // maxHeap.offer(root.val);
//         // dfs(root.left,k,maxHeap);
//         // to optimize above I used this right side
//         // if(maxHeap.size()<k) dfs(root.right,k,maxHeap);
//         return maxHeap.peek();
//     }

//     public void dfs(TreeNode root, int k,  PriorityQueue<Integer> maxHeap){
//         if(root == null) return ;

//         maxHeap.offer(root.val);
//         if(maxHeap.size()>k){
//             maxHeap.poll();
//         }

//         dfs(root.left,k,maxHeap);
//         dfs(root.right,k,maxHeap);
//     }
// }

class Solution {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return; // ✅ Stop traversal once found
        }

        inorder(node.right, k);
    }
}
