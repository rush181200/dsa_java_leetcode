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

class Pair{
    int level;
    TreeNode node;

    Pair(TreeNode node,int level){
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        // 1st value will be level and next value will be node
        Queue<Pair> q = new LinkedList<>();

        Map<Integer, Integer> map = new TreeMap<>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int level = curr.level;
            map.put(level,node.val);
            if(node.left!=null){
                q.offer(new Pair(node.left,level+1));
            }
            if(node.right!=null){
                q.offer(new Pair(node.right,level+1));
            }   
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }
}