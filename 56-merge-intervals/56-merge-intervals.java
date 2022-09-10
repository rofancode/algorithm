class Solution {
    public int[][] merge(int[][] intervals) {
        //sort start, end 순으로 
        Arrays.sort(intervals, (a, b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]); 
        
        //input 정해지지 않아서, List에 저장 -> 나중에 전환
        List<int[]> merged = new ArrayList();
        
        //check overlab
        //처음 start / end 시간 지정 
        //-> preEnd >= start ; overlap  기존 int[] 데이터 수정 
        //-> preEnd < start  ; 새롭게 만들기
        
        int [] pre = intervals[0];
        merged.add(pre);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (pre[1] >= curr[0]) {
                pre[1] = Math.max(pre[1], curr[1]);
            } else {
                pre = curr;
                merged.add(pre);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
    // TIme: O(NlogN)+O(N) -> O(NlogN)
    // Space: O(2) -> O(1)
 }