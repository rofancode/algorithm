class Solution {
    public int[] searchRange(int[] nums, int target) {
        // binary search로 target 찾기
        // start 찾고, end찾기
        
        //System.out.println(mid);
        // target 안될때 까지  start--와 
        
        
        
        return new int[]{findBinary(nums, target, true),findBinary(nums, target, false)};
    }
    // binary searhc logN + N
    
    public int findBinary(int[] nums, int target, boolean isFirst) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        
        while (start <= end) {
            int mid = end - (end - start) / 2;
            int num = nums[mid];
            //first 는 nums[mid - 1] != target
            if (num == target) {
                if (isFirst) {
                    if(mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if(mid == n - 1 || nums[mid + 1] != target) {
                        return mid;
                    } else {
                        start = mid + 1;
                    }
                }
            } else if (num > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
    //logN
}