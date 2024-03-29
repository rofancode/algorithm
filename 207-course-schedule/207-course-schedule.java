class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) { 
        
        //선수과목 별 next setting -> HashMap <과목라벨,List>
        Map<Integer, List<Integer>> courseDict = new HashMap<>();
        for (int[] relation : prerequisites) {
            
            if (courseDict.containsKey(relation[1])) {
                courseDict.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> next = new LinkedList<>();
                next.add(relation[0]);
                courseDict.put(relation[1], next);
            }
        }
        
        boolean[] checked = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for (int curr = 0; curr < numCourses; curr++) {
            if (this.isCyclic(curr, courseDict, path, checked))
                return false;
        }
        
        return true;
    }
     // cyclic 있는 지 확인
    private boolean isCyclic(int curr, Map<Integer, List<Integer>> courseDict, boolean[] path, boolean[] checked) {
        
        // 이미 다녀온 곳으로 cycle이 아닌 경우
        if (checked[curr])
            return false;
        //System.out.println(curr+">>"+path[curr]);
        // 만약 내가 방문했던 곳을 다시 방문한다면? cycle
        if (path[curr]) 
            return true;
        
        // 결국 마지막 next 가 없는 곳 - (map에 없음) 까지 나온다면 cycle이 아니고
        // false return하는데 다른 list의 path확인 위해 방문했던 곳 false로 변경하고 return  
        if (!courseDict.containsKey(curr))
            return false;
        
        // tracking 전에 방문체크
        path[curr] = true; 
         
        boolean isCycle = false;
        // 1개 과목에 대해서  다음 과목 > 다음 > 계속 호출 - DFS
        for (int next : courseDict.get(curr)){
            isCycle = isCyclic(next, courseDict, path, checked);
            if (isCycle)
                break;
                
        }
        // backtracing 후 원상복귀
        path[curr] = false;
        //어차피 true면 for문 안돌고 새롭게 재귀 호출 안돈다. 
        checked[curr] = true;
        
        return isCycle;
    }
}

/*
tracking에 기존 path기록 안했을 경우
- time complexity = O(P + N*N) -> pre..훓으면서 map만들기 O(P)
최악으로 N개 courses에 대해서 각 course별로 tracking -> 시그마 N -> (N+1)N/2 -> N^2
- space complexity = O(P + N) -> map이랑 boolean 배열 + recursion 최악으로 N

tracking에 기존 path기록 한 경우
- time complexity = O(P + N) 
O(P) : map 만들기
O(N) : 한번 지나간 path에 대해 기록되어있어 각 course에 대해 1번씩 만 check하면됨
- space complexity = O(P + N) 
O(P) : map 만들기
O(N) : 배열 만들기, 모든 courses(N)에 대해 recursion

*/
