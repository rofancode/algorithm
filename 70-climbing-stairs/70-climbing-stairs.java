class Solution {
    public int climbStairs(int n) {
        int[] records = new int[n + 1];
        //            0번째 1 
        // i - 2    : 1번째 계단 1 = 1개           
        // i - 1    : 2번째 계단은 1+1 or 2   = 2개
        // i        : 3번째 계단은 (1+1 or 2) + 1 or 1 + 2  = 3개
        // i        : 4번째 계단은 ((1+1 or 2) + 1 or 1 + 2) + 1 or (1+1 or 2) + 2 => 3 + 2 => 5개 
        // -> i번째는 (i - 1 번째 + 1) + (i - 2 번째 + 2) 
        // 여기서는 갯수를 구하는 거니까 
        // i번째 path 갯수는 i - 1번째 + 1 + i - 2번째 + 2 이다. 
        if (n == 1)
            return 1;
        
        records[1] = 1;
        records[2] = 2; // n >= 1
        for (int i = 3; i <= n; i++) {   
            records[i] += records[i - 2] + records[i - 1];
        }
        return records[n];
        //T.C (n)  // 길이 n만큼 loof
        //S.C (n) //임시배열1개 추가 생성
    }
}