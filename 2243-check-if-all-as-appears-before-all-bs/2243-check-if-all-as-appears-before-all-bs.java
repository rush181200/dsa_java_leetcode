class Solution {
    public boolean checkString(String s) {
        int lastB = Integer.MAX_VALUE;
        int lastA = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'a'){
                lastA = i;
            }
            if(s.charAt(i) == 'b'){
                lastB = i;
            }
            if(lastA>lastB){
                System.out.println("lastA: "+lastA);
                System.out.println("lastB: "+lastB);
                return false;
            } 
        }
        return true;
    }
}