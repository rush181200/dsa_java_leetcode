/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {

    
    public int guessNumber(int n) {
        long l = 1;
        
        while(l<=n){
            int m =(int) ((l+n)/2);
            int val = guess(m);
            if(val==0)return m;
            if(val==-1) n=m-1;
             if(val==1)l=m+1;
           
            
        }
        return -1;
    }
    
    
}