class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //HashMap 에 저장 
        //HashMap value로 내림차순 정렬
        //K만큼 선택
        
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 1) + 1);
        }
        
        List <Map.Entry<Integer, Integer>> list = new LinkedList(freq.entrySet());
        
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        
        int i = 0;
        int[] res = new int[k];
        for (Map.Entry<Integer, Integer> map : list) {
            if (i >= k) 
                break;
            res[i] = map.getKey();
            i++;
        }
        
        return res;
    }
}