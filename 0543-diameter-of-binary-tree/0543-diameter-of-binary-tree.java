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
class Solution {
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        ht(root);
        return ans-1;
         
    }

    public int ht(TreeNode root){
        if(root==null) return 0;
        int dl = ht(root.left);
        int dr = ht(root.right);
        ans = Math.max(ans,1+dl+dr);
        return 1+Math.max(dl,dr);
    }
}