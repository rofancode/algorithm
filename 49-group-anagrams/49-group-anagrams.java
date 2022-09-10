class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] isVisited = new boolean[strs.length];
        List<List<String>> group = new ArrayList();
        
        for (int i = 0; i < strs.length; i++) {
            if (!isVisited[i])
                group.add(findAnagrams(i, strs, isVisited));
        }
        
        return group;
    }
    
    public List<String> findAnagrams(int idx, String[] strs, boolean[] isVisited) {
        List<String> anagram = new ArrayList();
        String target = strs[idx];
        anagram.add(target);
        
        isVisited[idx] = true;
        
        int [] letter = new int[26];
        for (int i = idx + 1; i < strs.length; i++) {
            if (!isVisited[i] && target.length() == strs[i].length()) {
                String str = strs[i];
                for (int l = 0; l < target.length(); l++){
                    letter[target.charAt(l) - 'a']++;
                    letter[str.charAt(l) - 'a']--;
                }
                
                boolean isAnagram = true;
                for (int l = 0; l < 26; l++) {
                    if (letter[l] != 0) {
                        isAnagram = false;
                        letter[l] = 0;
                    }
                }
                
                if (isAnagram) {
                    anagram.add(str);
                    isVisited[i] = true;
                }
                   
            }
        }
        
        
        
        return anagram; 
    }
}