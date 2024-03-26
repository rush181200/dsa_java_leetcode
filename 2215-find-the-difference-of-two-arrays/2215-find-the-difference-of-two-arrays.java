class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        Set<Integer> l11 = new HashSet<>();
        Set<Integer> l21 = new HashSet<>();
        List<Set<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<nums1.length;i++){
            l1.add(nums1[i]);
        }
        for(int j=0;j<nums2.length;j++){
            l2.add(nums2[j]);
            if(!l1.contains(nums2[j])){
                l21.add(nums2[j]);
            }
        }
        
        for(int j=0;j<nums1.length;j++){
            
            if(!l2.contains(nums1[j])){
                l11.add(nums1[j]);
            }
        }
        
        
        ans.add(l11);
        ans.add(l21);
        List<List<Integer>> resultList = new ArrayList<>();
        for (Set<Integer> set : ans) {
            List<Integer> list = new ArrayList<>(set);
            resultList.add(list);
        }
        return resultList;
    }
}