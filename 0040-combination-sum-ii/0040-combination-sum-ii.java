class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      res = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(0,new ArrayList<>(),0,candidates,target);
        return res;
    }

    public void dfs(int i, List<Integer> cur, int total,int[] candidates , int target){
        if(total == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(total>target || i == candidates.length){
            return;
        }

        for(int j=i;j<candidates.length;j++){
            if(j>i && candidates[j] == candidates[j - 1]) continue;
            cur.add(candidates[j]);
            dfs(j+1,cur,total+candidates[j],candidates,target);
            cur.remove(cur.size()-1);
        }
    }
}