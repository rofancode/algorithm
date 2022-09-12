class Solution {
    public int countSubstrings(String s) {
        //for문으로 
        //i기준으로 i+1이랑 같으면 짝수 loof
        //i기준으로 홀수 loof
        //i기준으로 옆으로 퍼져나가기
        int len = s.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            
            cnt += cntPalindromic(s, i, i + 1); //even
            
            cnt += cntPalindromic(s, i, i); //odd
        }
        return cnt;
    }//time complexity = N * (N/2*2) = O(N^2), space complexity = S(1)
    
    private int cntPalindromic(String s, int l, int r) {
        int k = 0;
        
        while (l - k >= 0 && r + k < s.length()) {
            if (s.charAt(l - k) != s.charAt(r + k))
                    break;
            k++;
        }
        return k;
    }
}