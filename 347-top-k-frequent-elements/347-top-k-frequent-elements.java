class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //HashMap 에 저장 
        //HashMap value로 내림차순 정렬
        //K만큼 선택
        if (k == nums.length) return nums;
        
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) { //O(N)
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        //완 전 쩐다!ㅋㅋ
        for (int n : count.keySet()) { // heap k만큼 크기 유지 - 삽입 삭제 > O(logk) * N => O(NlogK)
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }
        
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll();
        }
        return res;
    }
    //time complexity = O(NlogK) -> O(NlogN)
    //space complexity = O(N + k)
}