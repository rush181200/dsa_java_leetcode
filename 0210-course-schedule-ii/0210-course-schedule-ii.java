class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
             // Build Adjaceny List(course -> preq)
        Map<Integer,ArrayList<Integer>> adj = new HashMap<>();

        for(int i=0;i<numCourses;i++){
            adj.put(i,new ArrayList<>());
        }

         int[] indegree = new int[numCourses];

        for(int[] it : prerequisites){
          int course = it[0];
          int pre = it[1];
            adj.get(pre).add(course);  // pre -> course which is also way of getiing neighbour
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int[] topo = new int[numCourses];
        int ind = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[ind++] = node;

            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        if(ind == numCourses) return topo;
       
        return new int[]{};
      }
}