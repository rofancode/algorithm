class Solution {
    public int longestStrChain(String[] words) {
        
        // 접근 방식 
        // word : ab -> *ab, a*b, ab* 랜덤글자추가 -> currentWord 에서 1자씩 삭제해서 이전 word중에 있는 지 확인
        // 검색 - hashMap - 각 글자의 최대 length 를 저장 
        
        Map<String, Integer> memo = new HashMap<>();
        
        // 글자는 글자length 순으로 정렬
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        int longestSequenceLength = 1;
        
        // words iterate
        for (String word : words) {
            
            int currLength = 1;
            // for curr글자에서 1자씩 삭제해서 map에서 search
            // -> 있으면, 기존 length + 1 vs currentlength 중 Max를 crrentlength로 저장
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i); //글자 삭제
                String predecessor = sb.toString();
                int prevLength = memo.getOrDefault(predecessor, 0); //없으면 0
                currLength = Math.max(prevLength + 1, currLength); // Max값 저장
            }
            
            // for 끝나고 map 에 해당 글자, currentlength 저장
            memo.put(word, currLength);
            
            // 가장 긴 Sequence Length 찾아야하므로 현재 currentlength랑 maxlength랑 비교
            longestSequenceLength = Math.max(longestSequenceLength, currLength);
        }
        
        return longestSequenceLength;
    }
}