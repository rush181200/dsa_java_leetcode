// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         Map<Integer, List<Integer>> adjList = new HashMap<>();

//         // Initialize adjacency list for all courses
//         for (int i = 0; i < numCourses; i++) {
//             adjList.put(i, new ArrayList<>());
//         }

//         // Build the adjacency list from prerequisites
//         for (int[] pre : prerequisites) {
//             int course = pre[0];  // Course to be taken
//             int prereq = pre[1];  // Prerequisite course
//             adjList.get(prereq).add(course); // Add dependency
//         }

//         int[] visitSet = new int[adjList.length];

//         boolean ans = dfs(visitSet,adjList);

//         return ans;
//     }

//     public boolean dfs(int[] visitSet, Map<Integer, List<Integer>> adjList){

//     }
// }

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adjList.get(prereq).add(course);
        }

        // Step 2: Initialize visited array
        int[] visitSet = new int[numCourses];

        // Step 3: Check for cycles using DFS
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, visitSet, adjList)) return false;
        }
        return true;
    }

    public boolean dfs(int course, int[] visitSet, Map<Integer, List<Integer>> adjList) {
        if (visitSet[course] == 1) return true;  // Cycle detected
        if (visitSet[course] == 2) return false; // Already processed

        visitSet[course] = 1;  // Mark node as visiting

        for (int next : adjList.get(course)) {
            if (dfs(next, visitSet, adjList)) return true; // Cycle found
        }

        visitSet[course] = 2;  // Mark node as fully processed
        return false;
    }
}
