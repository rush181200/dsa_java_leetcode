class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int vis[] = new int[n];
        int indegree[] = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
                
            }
        }
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjRev.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            // i -> it
            // it -> i
            for (int it : adj.get(i)) {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        
        
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> l = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.remove();
            l.add(node);
            for(int it:adjRev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                q.add(it);
            }
            }
        }
        
       Collections.sort(l);
        return l;
    }
}