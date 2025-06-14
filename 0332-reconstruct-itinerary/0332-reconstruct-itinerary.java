// class Solution {
//     private Map<String, List<String>> flightGraph;
//     private List<String> itinerary;

//     public Solution() {
//         flightGraph = new HashMap<>();
//         itinerary = new ArrayList<>();
//     }

//     // Depth-First Search to traverse the flight itinerary
//     private void dfs(String airport) {
//         List<String> destinations = flightGraph.get(airport);

//         // Visit destinations in lexical order
//         while (destinations != null && !destinations.isEmpty()) {
//             String nextDestination = destinations.remove(destinations.size() - 1);
//             dfs(nextDestination);
//         }

//         // Add the current airport to the itinerary after visiting all destinations
//         itinerary.add(airport);
//     }

//     public List<String> findItinerary(List<List<String>> tickets) {
//         // Populate the flight graph using ticket information
//         for (List<String> ticket : tickets) {
//             String from = ticket.get(0);
//             String to = ticket.get(1);

//             flightGraph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
//         }

//         // Sort destinations in reverse order to visit lexical smaller destinations first
//         for (List<String> destinations : flightGraph.values()) {
//             destinations.sort(Collections.reverseOrder());
//         }

//         // Start the DFS from the JFK airport
//         dfs("JFK");

//         // Reverse the itinerary to get the correct order
//         Collections.reverse(itinerary);

//         return itinerary;
//     }
// }
class Solution {
    private Map<String, PriorityQueue<String>> adj;
    private LinkedList<String> result;

    public Solution() {
        adj = new HashMap<>();
        result = new LinkedList<>();
    }

    private void dfs(String fromAir) {
        PriorityQueue<String> neighbors = adj.get(fromAir);
        while (neighbors != null && !neighbors.isEmpty()) {
            String toAir = neighbors.poll(); // get smallest lex neighbor
            dfs(toAir);
        }
        // Add to the front of result (reverse post-order)
        result.addFirst(fromAir);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        result = new LinkedList<>();

        for (List<String> str : tickets) {
            String u = str.get(0);
            String v = str.get(1);
            adj.computeIfAbsent(u, k -> new PriorityQueue<>()).add(v);
        }

        dfs("JFK");
        return result;
    }
}
