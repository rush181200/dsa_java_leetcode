class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] flags = new boolean[3];

        for(int[] t: triplets){
            if(t[0]>target[0] ||t[1]>target[1]  || t[2]>target[2]) continue;
            if(t[0]==target[0]) flags[0] = true;
            if(t[1]==target[1]) flags[1] = true;
            if(t[2]==target[2]) flags[2] = true;

            if(flags[0]&&flags[1]&&flags[2]) return true;
        }

        return false;
    }
}