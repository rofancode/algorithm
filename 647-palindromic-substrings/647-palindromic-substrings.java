class Solution {
    public int countSubstrings(String s) {
        //for문으로 
        //i기준으로 i+1이랑 같으면 짝수 loof
        //i기준으로 홀수 loof
        //i기준으로 옆으로 퍼져나가기
        int len = s.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            
            int k = 0;
            //even     
            while ( i - k >= 0 && i + 1 + k < len) {
                if (s.charAt(i - k) != s.charAt(i + 1 + k))
                    break;
                k++;
            }
            cnt += k;
            
            k = 0;
            //odd
            while (i - k >= 0 && i + k < len) {
                if (s.charAt(i - k) != s.charAt(i + k))
                    break;
                k++;
            }
            cnt += k;
        }
        return cnt;
    }
}