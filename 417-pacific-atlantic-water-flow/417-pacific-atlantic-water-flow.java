class Solution {
    private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int[][] heights;
    private int row;
    private int col;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
    /*
     target 기준에서 4개 방향으로 , 작은 숫자 기준으로 뻗어나가기 
     그럼 P -> A 방향으로 1번 A -> P 방향으로 1번 
     방문한 곳은 방문 check하기 
     
     -- 거꾸로 가기! 결국에는 바다에 도착해야하므로, 바다쪽부터 거슬러 올라가기 
     확실한 곳에서 부터 시작!
     
     가로 check 
     - pacific col = 0 고정, 각 row, 0 에서 이동 가능한 지 체크 
     - atlantic col = colLen -1 고정, 이동가능한 지 체크
     
     세로 check
     - pacific row = 0 고정 
     - atlantic row = rowLen - 1 고정,
    */
        this.heights = heights;
        this.row = heights.length;
        this.col = heights[0].length;
        
        boolean[][] toAtlantic = new boolean[row][col];
        boolean[][] toPacific = new boolean[row][col];
        // print(heights);
        
        // 가로 check
        for (int i = 0; i < row; i++) {
            dfs(toPacific, i, 0);
            dfs(toAtlantic, i, col - 1);
        }
        
        //세로 check
        for (int j = 0; j < col; j++) {
            dfs(toPacific, 0, j);
            dfs(toAtlantic, row - 1, j);
        }
        // print(toAtlantic);
        // print(toPacific);
        List<List<Integer>> list = new ArrayList();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++){
                if (toAtlantic[i][j] && toPacific[i][j]) {
                    list.add(List.of(i, j));
                }
                    // list.add(Arrays.toList(i,j));
            }
        }
        
        return list;
    }
    private void dfs(boolean[][] toOcean, int i, int j) {
        toOcean[i][j] = true;
        
        for (int [] dir : dirs) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            //idx 범위 확인
            if (newRow < 0 || newCol < 0 || newRow >= row || newCol >= col)
                continue;
            //방문한 곳 제외
            if (toOcean[newRow][newCol])
                continue;
            //바다부터 시작해서 갈수 있는 곳 확인하기 때문에 (거꾸로접근)
            // 새로운 곳이 더 낮으면 바다쪽으로 못간다.
            if (heights[i][j] > heights[newRow][newCol])
                continue;
            
            dfs(toOcean, newRow, newCol);
        }
    }
//     //to atlantic top, left -> bottom, right 
//     private boolean checkAtlantic (boolean[][] toOcean, int i, int j) {
//         boolean isArrived = false;
        
//         if (i == row - 1 || j == col - 1 || toOcean[i][j]) {
//             toOcean[i][j] = true;
//             return true;
//         }
        
//         if (heights[i][j] >= heights[i][j + 1])
//             isArrived = checkAtlantic(toOcean, i, j + 1);
        
//         if (!isArrived && heights[i][j] >= heights[i + 1][j])
//             isArrived = checkAtlantic(toOcean, i + 1, j);
        
//         toOcean[i][j] = isArrived;
        
//         return isArrived;
//     }
//     //to pacific bottom, right -> top, left
//     private boolean checkPacific (boolean[][] toOcean, int i, int j) {
//         boolean isArrived = false;
        
//         if (i == 0 || j == 0 || toOcean[i][j]) {
//             toOcean[i][j] = true;
//             return true;
//         }
        
//         if (heights[i][j - 1] <= heights[i][j] )
//             isArrived = checkPacific(toOcean, i, j - 1);
        
//         if (!isArrived && heights[i - 1][j] <= heights[i][j])
//             isArrived = checkPacific(toOcean, i - 1, j);
        
//         toOcean[i][j] = isArrived;
        
//         return isArrived;
//     }
    public void print(int[][] heights) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++){
                System.out.print(heights[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void print(boolean[][] toOcean) {
         for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++){
                System.out.print(toOcean[i][j]?"T ":"F ");
            }
            System.out.println();
         }
        System.out.println();
    }
}