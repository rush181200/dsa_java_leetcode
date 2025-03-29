

import java.util.*;

class Solution {
      public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build Adjaceny List(course -> preq)
        Map<Integer,ArrayList<Integer>> adj = new HashMap<>();

        for(int i=0;i<numCourses;i++){
            adj.put(i,new ArrayList<>());
        }

        for(int[] it : prerequisites){
          int course = it[0];
          int pre = it[1];
            adj.get(course).add(pre);
        }

        // Indegree
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            for( int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int preC = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            preC++;

            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        
        // boolean indegreeV = true;
        // for(int j = 0;j<indegree.length;j++){
        //     if(indegree[j]>0) indegreeV = false;
        // }
       

        return preC == numCourses ;
      }
}




















        // Step 1: Build adjacency list (course -> prerequisite list)
    //     Map<Integer, List<Integer>> preMap = new HashMap<>();
    //     for (int i = 0; i < numCourses; i++) {
    //         preMap.put(i, new ArrayList<>());
    //     }
    //     for (int[] pre : prerequisites) {
    //         int course = pre[0];
    //         int prereq = pre[1];
    //         preMap.get(course).add(prereq);
    //     }

    //     // Step 2: Initialize visited set (to track current DFS path)
    //     Set<Integer> visitSet = new HashSet<>();

    //     // Step 3: Check for cycles using DFS
    //     for (int course = 0; course < numCourses; course++) {
    //         if (!dfs(course, preMap, visitSet)) {
    //             return false;  // Cycle detected
    //         }
    //     }
    //     return true;  // No cycle found
    // }

    // private boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visitSet) {
    //     if (visitSet.contains(course)) return false; // Cycle detected
    //     if (preMap.get(course).isEmpty()) return true; // No prerequisites left to process

    //     visitSet.add(course);
    //     for (int prereq : preMap.get(course)) {
    //         if (!dfs(prereq, preMap, visitSet)) {
    //             return false;
    //         }
    //     }
    //     visitSet.remove(course);
    //     preMap.put(course, new ArrayList<>()); // Mark course as processed (memoization)

    //     return true;
    // }
// }
