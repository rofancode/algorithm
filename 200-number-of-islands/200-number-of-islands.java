class Solution {
    char[][] grid;
    int[][] dirs;
    public int numIslands(char[][] grid) {

        this.grid = grid;
        this.dirs = new int[][]{{0,-1},{0, 1},{-1, 0},{1,0}};
    
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    findIsland(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    } // T O(MN) //S O(8) -> O(1)

    public void findIsland(int i, int j) {
        // 1일 때 2로 변경하고, 
        grid[i][j] ='2';
        
        // 4개 방향으로  1일 때 호출 
        for (int [] dir : dirs ) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                findIsland(x, y);
            }
                
        }
    }
}