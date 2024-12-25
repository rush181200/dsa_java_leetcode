class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        int i =0;
        // left
        while(i<n&&intervals[i][1]<newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
        //middle
        while(i<n&&intervals[i][0]<=newInterval[1]){
           newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        result.add(newInterval);
        //right
        while(i<n){
           result.add(intervals[i]);
           i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}