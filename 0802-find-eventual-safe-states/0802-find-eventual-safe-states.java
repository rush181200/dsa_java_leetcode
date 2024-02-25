class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       //check for each node whether it is going to the terminal node
       // terminal node is nothing but node with no outgoing edges 
       // and the path leading to all the terminal node is a safe node
    
       // Approach : Use cycle detection concept for each nodes and check whether there exists a cycle 
       //Use DFS approach 

       // create visited 
       int n = graph.length;
       int[] visited = new int[graph.length];
       

       //create a List<Integer> to store all the safenodes value
       List<Integer> safeNodes = new ArrayList<Integer>();
       // create a loop to check safe nodes for each node=
    
       for(int i=0;i<n;i++)
       {
           //check if the current node is a safe node 
           if(dfs(i,graph,visited)) {
               safeNodes.add(i);
           }
       }
       //return the safenodes
       return safeNodes;
    }
    public boolean dfs(int vertex, int[][] graph, int[] visited)
    {
        //check if the current vertex is already visited 
        // if yes , check whether the visited vertex value is either 1 or 2 
        // if 1 return true, else return false
        if(visited[vertex]!=0) return visited[vertex]==1;
        // initially set the vertex's visited value as 2 which is the value for unsafe node
        visited[vertex]=2;
        // iterate the vertex's adj nodes
        for(int i : graph[vertex])
        {
            
          
                //call the dfs method recursively
                // return false if detected a cycle 
                if(!dfs(i,graph,visited)) return false;
            
        }
        //change the path visited to 1 if it has no cycle detected
        visited[vertex]=1;
        //return true if executed sucessfully
        return true;
    }
}


// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int n = graph.length;
//         int vis[] = new int[n];
//         int indegree[] = new int[n];
//         List<List<Integer>> adj = new ArrayList<>();
//         for(int i=0;i<n;i++){
//             adj.add(new ArrayList());
//         }
//         for(int i=0;i<n;i++){
//             for(int j=0;j<graph[i].length;j++){
//                 adj.get(i).add(graph[i][j]);
                
//             }
//         }
//         List<List<Integer>> adjRev = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             adjRev.add(new ArrayList<>());
//         }
//         for (int i = 0; i < n; i++) {
//             // i -> it
//             // it -> i
//             for (int it : adj.get(i)) {
//                 adjRev.get(it).add(i);
//                 indegree[i]++;
//             }
//         }
        
        
//         Queue<Integer> q = new LinkedList<Integer>();
//         List<Integer> l = new ArrayList<Integer>();
//         for(int i=0;i<n;i++){
//             if(indegree[i] == 0){
//                 q.add(i);
//             }
//         }
        
//         while(!q.isEmpty()){
//             int node = q.remove();
//             l.add(node);
//             for(int it:adjRev.get(node)){
//                 indegree[it]--;
//                 if(indegree[it] == 0){
//                 q.add(it);
//             }
//             }
//         }
        
//        Collections.sort(l);
//         return l;
//     }
// }