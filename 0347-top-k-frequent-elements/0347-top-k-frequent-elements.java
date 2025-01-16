import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        // Frequency map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Priority queue (min-heap) based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        // Add entries to the heap, keeping only the k most frequent elements
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove the least frequent element
            }
        }
        
        // Extract the top k frequent elements
        int[] ans = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            ans[index++] = minHeap.poll().getKey();  // Get the key (number)
        }

        return ans;
    }
}
