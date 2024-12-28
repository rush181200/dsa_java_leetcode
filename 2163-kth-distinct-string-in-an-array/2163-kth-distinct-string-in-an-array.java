// class Solution {
//     public String kthDistinct(String[] arr, int k) {
//         int n = arr.length;
//         if(n<k) return "";
//         ArrayList<String> a = new ArrayList<>();

//         for(int i=0;i<n;i++){
//             if(a.contains(arr[i])){
//               a.remove(arr[i]);  
//             }else{
//                 a.add(arr[i]);
//             }
//         }
//         StringBuilder sb = new StringBuilder();
//         for(int i=0;i<a.size();i++){
//             if(i==k-1) sb.append(a.get(i)); 
//         }
//        return sb.toString();
//     }
// }
class Solution {
    public String kthDistinct(String[] arr, int k) {
        // Map to count occurrences of each string
        HashMap<String, Integer> freqMap = new HashMap<>();
        
        // Count occurrences of each string
        for (String s : arr) {
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }
        
        // Iterate over the array to find the kth distinct string
        for (String s : arr) {
            if (freqMap.get(s) == 1) { // Only consider distinct strings
                k--;
                if (k == 0) {
                    return s;
                }
            }
        }
        
        // If k distinct strings are not found, return an empty string
        return "";
    }
}
