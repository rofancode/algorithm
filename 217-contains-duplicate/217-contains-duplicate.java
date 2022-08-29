class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true; //search()
            set.add(x); //insert()
        }

        return false;
    }
}
//time complexity : O(n)
//space : O(n)