class Solution {
    List<List<Integer>> out;
    int[] nums;
    
    public List<List<Integer>> threeSum(int[] nums) {
        this.out = new ArrayList();
        this.nums = nums;
        //target 기준 잡고 two sum 찾기
        //중복된 tripelt은 없음
        
        //sort
        Arrays.sort(nums);   ////O(NlogN)
        
        for (int i = 0; i < nums.length && nums[i] <= 0; i++){ //O(N)
            if (i == 0 || nums[i - 1] != nums[i])
                twoSum(i);
        }
        
        return out;
        
    }
    
    private void twoSum(int targetIdx) {
        
        
        int left = targetIdx + 1;
        int right = nums.length - 1;
        
        while (left < right) {//O(N)
            //더해서 0 찾기
            int sum = nums[targetIdx] + nums[left] + nums[right];
            
            //만약 이전 leftVal과 동일하면 continue
            if (left > targetIdx + 1 && nums[left - 1] == nums[left]) {
                ++left;
                continue;
            } 
            
            if (sum == 0){
                out.add(Arrays.asList(nums[targetIdx], nums[left], nums[right]));
                ++left;
                --right;
            } 
            else if (sum < 0)
                ++left;
            else 
                --right;
        }
        
    }
    //time  complexity = O(N^2)
    //space complexity = O(1)
    
}