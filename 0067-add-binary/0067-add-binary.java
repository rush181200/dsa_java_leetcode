class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
// class Solution {
//     public String addBinary(String a, String b) {
       
//         // Step 1: Convert binary strings to integers
//         int numA = Integer.parseInt(a, 2);
//         int numB = Integer.parseInt(b, 2);
//         System.out.println(numA);
//         // Step 2: Add the two integers
//         int sum = numA + numB;

//         // Step 3: Convert the result back to a binary string
//         String binarySum = Integer.toBinaryString(sum);
// // 
//         return binarySum;
//     }
// }