public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 가장 끝의 값을 ans에 넣는 것 
            // 가장 끝의 값 떼어내기 - n & 1
            // ans에 넣기 ans 처음에는 무조건 0 이고, 다음에는 1칸이동 하니까 끝은 0
            ans <<= 1; //맨처음 0은 없는 취급되니까 1칸 넘기고 연산
            
            ans = ans | (n & 1);
            
            n >>= 1;
           
        }
            
        return ans;
    }
}