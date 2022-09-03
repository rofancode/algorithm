class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // 정렬 - end asc, start asc
        // 1. end 기준으로 가장 빨리 끝나는 순으로 선택
        // 1-1. end <= start 회의를 먼저 지정
        // 1-2  end > start 시간이면 넘어간다. 만약에 지정 안되면 새로운 meetingRooms을 빌린다. 
         
        //List<int-end시간만 넣기>
        
        //1. sort ->  end asc, start asc
        Arrays.sort(intervals, (a, b) -> a[0] == b[0]? a[1] - b[1] :a[0] - b[0]);
        
        // for (int[] arr : intervals) {
        //     System.out.println(arr[0]+" | "+arr[1]);
        // }
        //2. loof intervals.length 기준으로 돌면서 rooms iterate, 
        // end <= start rooms에 end시간 변경해줌
        // end > start 시간 다음 rooms 찾아서 end 값 변경  없으면 rooms에 end시간 추가함  
        
        List<Integer> rooms = new ArrayList();
        rooms.add(0); //초기화 
        
        for (int[] meeting : intervals) {
            boolean isInserted = false;
            for(int j = 0; j < rooms.size(); j++) {
                int end = rooms.get(j);
                //System.out.println("target >> ["+j+"]room : "+end+" | start :"+meeting[0]);
                if (end <= meeting[0]) { // start 시간 비교하고
                    rooms.set(j, meeting[1]); //회의지정 = end값을 update
                    isInserted = true;
                    //System.out.println("inserted >> "+rooms.get(j));
                    break;
                }
            }
            if (!isInserted)
                rooms.add(meeting[1]);
        }
        return rooms.size();
  
    }
}