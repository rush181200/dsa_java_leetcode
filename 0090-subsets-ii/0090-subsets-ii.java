class Solution {
    public void findSumSubset(int ind,List<List<Integer>> ansList,List<Integer>ds, int[] nums){
        ansList.add(new ArrayList<>(ds));
        for(int i = ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            findSumSubset(i+1,ansList,ds,nums);
            ds.remove(ds.size()-1);

        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSumSubset(0,ansList,new ArrayList<>(), nums);
        return ansList;
    }
}