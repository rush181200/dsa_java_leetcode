class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        
        Map<Integer,Integer> map = new HashMap<>();
       List<Integer> arr = new ArrayList<>();
        for(int n:nums){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }else{
                map.put(n,1); 
            }
           
        }
         Map<Integer, Integer> sortedMap = map.entrySet()
            .stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));

        // Print the sorted map
        System.out.println("Sorted map (descending by values): " + sortedMap);
        int count = k;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()){
            System.out.println("map key"+entry.getKey());
             System.out.println("map value"+entry.getValue());
            
          
               arr.add(entry.getKey());
             
        }
        System.out.println("array"+arr);
        
        int[] ans = new int[k];
        for(int i=0;i<arr.size();i++){
            System.out.println("arr"+arr.get(i));
            if(count>0){
                ans[i] = arr.get(i);
            }
            count--;
            
        }
        
        return ans;
    }
}