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
       ht(root,0);
        return ans-1;
    }

    public int ht(TreeNode root, int maxC){
        if(root==null){
            return 0;
        }
        int dl = ht(root.left,maxC);
        int dr = ht(root.right,maxC);
        ans = Math.max(ans,1+dl+dr); // max diameter even for shorter parts

        return 1+Math.max(dl,dr);// height for longer part
    }
}