class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 1;
        int n = intervals.length;
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int freetime = intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]>=freetime){
                count+=1;
                freetime = intervals[i][1];
            }
        }

        return n-count;
    }
}