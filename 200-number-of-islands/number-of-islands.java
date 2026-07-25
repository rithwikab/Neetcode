class Solution {
    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid, int r, int c){
        if(r<0 || r>=grid.length || c<0 || c>= grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        for(int[] d: dirs){
            dfs(grid, r+d[0], c+d[1]);
        }
    }
}