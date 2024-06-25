class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> answer = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            answer.add(nums[i]);
        }
         int index = 0;
        for (int num : answer) {
            nums[index++] = num;
        }
        return answer.size();
    }
}