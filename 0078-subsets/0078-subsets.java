class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        dfs(res,nums,0,curr);

        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, int i, List<Integer> curr){
        if(i==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
            curr.add(nums[i]);
            dfs(res,nums,i+1,curr);
            curr.remove(curr.size()-1);
            dfs(res,nums,i+1,curr);
    }
}