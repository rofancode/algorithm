public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //System.out.println(n);
        //2나누고 % 1되면 cnt ++ 
        // 
        //
        int cnt = 0;
        int mask = 1;
        boolean isNegative = false;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                cnt++;
            }
            mask <<= 1;
        }

        return cnt;
    }//T.C (1), S.C (1)
}