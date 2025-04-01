class Pair{
    int [] arr;
    int value;

    Pair(int[] arr, int val){
   this.arr = arr;
   this.value = val;
}
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->b.value - a.value);
        for(int[] point : points){
            int aClose =point[0] * point[0];
            int bClose =point[1] * point[1];
            int curr = aClose + bClose;
            maxHeap.offer(new Pair(new int[]{point[0],point[1]},curr));
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int[][] ans = new int[maxHeap.size()][2];
        int i=0;
        while(!maxHeap.isEmpty()){
            ans[i] = maxHeap.poll().arr;
            i++;
        }
        return ans;
    }
}