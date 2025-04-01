class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            maxHeap.offer(stone);
        }
        int y = 0;
        int x = 0;

        while(!maxHeap.isEmpty()){
            y = maxHeap.poll();
            if(maxHeap.isEmpty()) return y;
            x = maxHeap.poll();

            if(x==y) continue;
            else{
                maxHeap.offer(y-x);
            }
        }
        return 0;
    }
}