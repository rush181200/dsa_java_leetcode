class Solution {
    public int countPoints(String rings) {
        int n = rings.length();
        String[] arr = new String[10];
        // Initialize all array elements to empty strings
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "";
        }
        for(int i=0;i<n;i=i+2){
           char color = rings.charAt(i);
           int index = rings.charAt(i+1) -'0';
           arr[index] += color; 
        }
        int count =0;
        for(String s : arr){
            if (s.contains("R") && s.contains("G") && s.contains("B")) {
                count++;
            }
        }

        return count;
    }
}