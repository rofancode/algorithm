class Solution {
    List<List<Integer>> out;
    int[] nums;
    
    public List<List<Integer>> threeSum(int[] nums) {
        this.out = new ArrayList();
        this.nums = nums;
        //target 기준 잡고 two sum == -target 찾기
        //중복된 tripelt은 없음
        
        //sort
        Arrays.sort(nums);
        
        //for target 선택 -> 같은 값이면 continue;
        //-> twosum  -> 하나만 찾으면 되나? 
        //-> target = -4, twosum 4되어야하는데 
        // 1 + 3, 2 + 2 둘다 return하는 거겠지?
        // -4, -1, -1, 0, 1, 2
        // -4, 1, 1, 2, 2, 3, 3,
        //     |              | 찾음 -> left를 똑으면 ++ 그 다음에 right를 옮기는 거지 
        //그리고 target이 0보다 크면 더이상 twoSum 할 필요가 없네 
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0) return out;
            if (i != 0 && nums[i - 1] == nums[i]) continue;
            twoSum(i);
        }
        
        return out;
        
    }
    
    private void twoSum(int targetIdx) {
        int target = nums[targetIdx] * -1;
        
        int left = targetIdx + 1;
        int right = nums.length - 1;
        
        while (left < right) {
            //더해서 target과 동일한 값 찾기
            
            int sum = nums[left] + nums[right];
            
            //만약 이전 leftVal과 동일하면 continue
            if (left > targetIdx + 1 && nums[left - 1] == nums[left]) {
                ++left;
                continue;
            } 
            
            if (sum == target){
                out.add(Arrays.asList(nums[targetIdx], nums[left], nums[right]));
                ++left;
                --right;
            } 
            else if (sum < target)
                ++left;
            else 
                --right;
        }
        
    }
    
}