import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        // 중복확인 SET을 이용해서 값이 있으면 true return
        Set <Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
            
            
        return false;
    }
}