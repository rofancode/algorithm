/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        //왼쪽은 < 기준 node val = 최대값
        //오른쪽은 > 기준 node = 최소값 
        // 같은 값은? 같은 값은 왼쪽에 포함한다고 하자
        // int max = Integer.MAX_VALUE;
        // int min = Integer.MIN_VALUE;
        
        return checkVaild(root, null, null);
        
    }
    
    private boolean checkVaild(TreeNode node, Integer max, Integer min) {
        if (node == null) return true;
        if ((max != null && node.val >= max) || (min != null && node.val <= min)) return false;
        
        return checkVaild(node.left, node.val, min) //왼쪽 최대 값 = node.val
            && checkVaild(node.right, max, node.val); //오른쪽 최솟값 = node.val
    }
}