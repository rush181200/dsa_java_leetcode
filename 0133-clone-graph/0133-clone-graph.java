// class Node {
//     public int val;
//     public List<Node> neighbors;
    
//     public Node() {
//         val = 0;
//         neighbors = new ArrayList<>();
//     }

//     public Node(int _val) {
//         val = _val;
//         neighbors = new ArrayList<>();
//     }

//     public Node(int _val, ArrayList<Node> _neighbors) {
//         val = _val;
//         neighbors = _neighbors;
//     }
// }

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // Use BFS to clone the graph
        return bfsClone(node);
    }

    public Node bfsClone(Node node) {
        // Mapping of original nodes to cloned nodes
        Map<Node, Node> cloneMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        // Create a new node for the start node and add to map
        Node newNode = new Node(node.val);
        cloneMap.put(node, newNode);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();  // Original node

            for (Node neighbor : curr.neighbors) {
                if (!cloneMap.containsKey(neighbor)) {
                    // Clone the neighbor and store in map
                    cloneMap.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }

                // Add the cloned neighbor to the current cloned node's neighbors list
                cloneMap.get(curr).neighbors.add(cloneMap.get(neighbor));
            }
        }

        return newNode;
    }
}
