class Solution{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(0,new ArrayList<>(),0,candidates,target, res);
        return res;
    }

    public void dfs(int index, List<Integer> list, int currSum,int[] candidates, int target,List<List<Integer>> res){
        if(currSum == target){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if(currSum+candidates[i]>target) return;
            list.add(candidates[i]);
            dfs(i,list,currSum+candidates[i],candidates,target, res);
            list.remove(list.size()-1);
        }

    }

}

// class Solution {
//     List<List<Integer>> res;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         res = new ArrayList<>();
//         Arrays.sort(candidates);

//         dfs(0,new ArrayList<>(),0,candidates,target);
//         return res;
//     }

//     public void dfs(int i, List<Integer> cur, int total,int[] candidates , int target){
//         if(total == target){
//             res.add(new ArrayList<>(cur));
//             return;
//         }
//         for(int j=i;j<candidates.length;j++){
//             if(total+candidates[j]>target){
//                 return;
//             }
//             cur.add(candidates[j]);
//             dfs(j,cur,total+candidates[j],candidates,target);
//             cur.remove(cur.size()-1);
//         }
//     }
// }