class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) 
            return false;
        
        long x = (long) n; // long :  64-bit two's complement integer n <= 2^31 - 1 

        return (x & -x) == x;
    }
}// logN

/**
    Two's complement - 2의 보수 = 음수
    -x = ~x + 1  
1 -> 0000 0001   1111 1110 + 1 = 1111 1111      | x & (-x) = 0000 0001
2 -> 0000 0010   1111 1101 + 1 = 1111 1110      | x & (-x) = 0000 0010
4 -> 0000 0100   1111 1011 + 1 = 1111 1100      | x & (-x) = 0000 0100
8 -> 0000 1000   1111 0111 + 1 = 1111 1000      | x & (-x) = 0000 1000

3 -> 0000 0011   1111 1100 + 1 = 1111 1101      | x & (-x) = 0000 0001

비트 연산 
a & b -> a == b ? a : 0;
a | b -> a == 0 && b == 0 ? 0 : 1;
a ^ b -> a == b ? 0 : 1;
 
2 ^ k 형태인 경우, x & -x = x 
long :  two's complement integer
*/
