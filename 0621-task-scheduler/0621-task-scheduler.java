class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for(char c : tasks){
            cnt[c-'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int c :  cnt){
            if(c>0) maxHeap.add(c);
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        while(!maxHeap.isEmpty()||!q.isEmpty()){
            time++;

            if(maxHeap.isEmpty()){
                time = q.peek()[1]; // if maxHeap is we go to that time when it is free
            }else{
                int cnt1 = maxHeap.poll()-1;
                if(cnt1>0) q.add(new int[]{cnt1,time+n});
            }

            if(!q.isEmpty() && q.peek()[1]==time){
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }
}