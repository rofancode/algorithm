class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        // ** non - overlapping의 정의 ** = intervals사이에 곂치는 영역이 없어야하는것. 
        // previous end = curr start 포함
        
        // 곂치는 것 찾아서 
        
        // 정렬 
        Arrays.sort(intervals, (a, b) -> a[1] == b[1]? a[0] - b[0] : a[1] - b[1]);
        
        int sum = countOverlapping(intervals);
        
     
        return intervals.length - sum;
    }
    
    private int countOverlapping(int[][] intervals) {
        //
        
        int cnt = 1; //제거 해야할 갯수!
        
        if (intervals.length == 0) return 0;
        //범위 
        //int start = intervals[0][0];
        int end = intervals[0][1];
        // end 값 순으로 정렬했을 떄 // overlapping 은 start 가 prev
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            
            if (interval[0] >= end) {  //지금 남아있는 것과 이전꺼 간의 간격 없음.
                cnt++;
                end = interval[1]; 
            } 
            
            //start < end 작으면 그것도 overlapping할 수 있는건데.. 
        }
        
        return cnt;
    }
}