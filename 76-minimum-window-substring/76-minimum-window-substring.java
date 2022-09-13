class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        // t 값을 전부 HashMap에 넣고, cnt도 넣음 
        // s하나씩 뽑아서 확인
        // idea 는 
        /*
        left랑 right pointer가 0에서 시작함, 
        //1. 일단 t에 해당하는 글자 1개 나올 때 까지 left++
        2. t에 해당하는 글자 전부 포함할 때 까지 right++
        -> window 정해짐
        
        left ++ 다음 t.의 글자 나올 때 까지 
        해당 window에서 글자 전부 들어가 있는 지 check
        - 아니면 2반복
        아니면 left++
        */
        // 문제는 어떻게 window내에 t 다 있는 지 확인하느냐인데, 
        // map을 2개 - 1개는 t용, 1개는 window용 
        // checking - 1) t용map에 있는 글자인지 2) 중복되는 글자 수도 맞는 지 
        
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }
        
        int required = dictT.size(); //필요한 글자수

        int l = 0, r = 0; //pointers
        
        int cnt = 0; //window내 글자 cnt 체크 
        
        Map <Character, Integer> winCnt = new HashMap();
        //저장해둔 값 비교해서 가장 작은 값일 때 글자 추출해야함
        int [] win = {-1, 0, 0}; //winSize, l, r, 
        
        while (r < s.length()) {
            char c = s.charAt(r);
            winCnt.put(c, winCnt.getOrDefault(c, 0) + 1);
            
            //t가 갖고 있고, 글자수도 같으면
            if (dictT.containsKey(c) && winCnt.get(c).intValue() == dictT.get(c).intValue()) {
                cnt++;
            }
                
            // 글자 다 포함하면, 글자 1개 누락할 때까지 left++          
            while (l <= r && cnt == required) {
                c = s.charAt(l);
                //처음이거나 window 저장 지금보다 작은 경우,  
                if (win[0] == -1 || r - l + 1 < win[0]) {
                        win[0] = r - l + 1;
                        win[1] = l;
                        win[2] = r;
                }
                //left이동으로 해당 글자 제외
                winCnt.put(c, winCnt.get(c) - 1);
                if (dictT.containsKey(c) && winCnt.get(c).intValue() < dictT.get(c).intValue()) {
                    cnt--;
                }
 
                l++;
            }
    
            r++;
            
        }
        
        return win[0] == -1 ? "" : s.substring(win[1], win[2] + 1);
    }
}//O(S + T) loof 에서 s 글자 check, 앞에서 map 에 T값 넣음
// O(S + T) 