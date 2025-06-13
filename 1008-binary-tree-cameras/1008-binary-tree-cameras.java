/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // 1 = camera placed | 0 = covered by child | -1 = needs camera
class Solution {
    int cameras = 0;
    int heightDFS(TreeNode node){
        if(node == null) return 0;

        int left = heightDFS(node.left);
        int right = heightDFS(node.right);

        if(left ==-1 || right ==-1){
            cameras++;
            return 1; // place camera here
        }
        if(left == 1 || right == 1){
            return 0; // covered by child
        }
        return -1;

    }
    public int minCameraCover(TreeNode root) {
        if(heightDFS(root)==-1) cameras++;
        return cameras;
    }
}