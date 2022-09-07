class Solution {
    public int[] twoSum(int[] nums, int target) {
        //나의 pair를 찾아야한다. 
        //검색 -> Set 
        //set에 target - num 있는 지 확인 없으면 set에 추가 
        Map<Integer, Integer> map = new HashMap();
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(target - num))
                return new int[]{map.get(target - num), i};
            else
                map.put(num, i);
        }
        
        return new int[]{-1,-1};
    }
}