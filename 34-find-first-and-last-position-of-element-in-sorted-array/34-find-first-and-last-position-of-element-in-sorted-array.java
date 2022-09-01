class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        
        int mid = 0;
        // binary search로 target 찾고
        while (start <= end ) {
            mid = end - (end - start) / 2;
            //mid = (start + end) / 2;
            System.out.println(mid);
            int num = nums[mid];
            
            if (num == target) {
                break;
            } else if (num > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            
        }
        
        if(start > end)
            return new int[]{-1, -1};
        
        //System.out.println(mid);
        // target 안될때 까지  start--와 
        
        for (int i = mid; i >= 0; i--) {
            if(nums[i] != target) {
                break;
            }
            start = i;
        }
        
        //end++를 
        for (int i = mid; i < nums.length; i++) {
            //System.out.println(i+"|"+nums[i]);
            if(nums[i] != target) {
                break;
            }
            end = i;
        }
        
        return new int[]{start, end};
    }
    
    
}