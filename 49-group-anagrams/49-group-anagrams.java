class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // str           -> char array -> sort -> Key값에 넣는다. 
        // N(strs의 len)    k(str의 len)  KlogK
        // HashTable에 최대길이가 K인 글자 N개가 저장되므로 NK
        // 
        Map<String, List<String>> map = new HashMap();
        
        for (String str: strs) {
            // char array
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            
            if (!map.containsKey(key))
                map.put(key, new ArrayList());
            
            map.get(key).add(str);
        }
        
        return new ArrayList(map.values());
    }
    
    //Time complexity O(NK)
    //Space complexity O(NK)
}