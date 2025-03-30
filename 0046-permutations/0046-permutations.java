class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, res, new ArrayList<>(), used);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, boolean[] used) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (used[j]) continue; // skip if already used

            used[j] = true;
            cur.add(nums[j]);

            dfs(nums, res, cur, used); // move forward

            // backtrack
            used[j] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
