class Solution {
    public int lengthOfLongestSubstring(String s) {
        //two pointers
        //not repeat -> right++;
        //repeat -> left 는 중복 글자의 이전 idx + 1로 변경; 
        // -> 길이 :  right - left + 1
        // how to know they are repeat
        // HastMap 에 글자별 idx 저장 
        // 만약 map에 글자 contain -> 1) idx < left -> left변경 대상 아님. (repeat 아님) -> right++
        // 2) idx > left 이면 left = idx + 1이 됨. ==> 공통적으로 idx 를 현재 값으로 변경 
        
        Map <Character, Integer> letters = new HashMap();
        int sLen = s.length();
        int left = 0, right = 0;
        
        int max = 0;
        while (right < sLen) {
            char c = s.charAt(right);
            
            if (letters.containsKey(c) ) {
                //left 변경 대상 
                left = Math.max(left, letters.get(c) + 1);    
            } 
            letters.put(c, right);
            max = Math.max(max, right - left + 1);
            right++;
            
        }

        return max;
    } //timecomplexity = O(N)
      //space complexity = O(M) size of table O(26) = O(1)
}