public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        System.out.println(n);
        //2나누고 % 1되면 cnt ++ 
        // 
        //
        boolean isNegative = false;
        if(n < 0){
            n = n*(-1) - 1; 
            isNegative = true;
        }
            
            
            
        int cnt = 0;
        while(n != 0) {
            if(n % 2 == 1)
                cnt++;
            n /= 2;
        }
        return isNegative? 32 - cnt: cnt;
    }
}