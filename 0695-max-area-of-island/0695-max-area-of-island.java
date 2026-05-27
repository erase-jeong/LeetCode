class Solution {
    static int rows, cols;

    public int maxAreaOfIsland(int[][] grid) {
        rows=grid.length;
        cols=grid[0].length;

        int maxArea=0;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1){
                    //섬 발견 -> DFS로 넓이 계산
                    int area=dfs(r,c,grid);
                    maxArea=Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int r, int c,int[][] grid){
        //범위 벗어나거나 바다면 0반환
        if(r<0 || r>=rows || c<0 || c>=cols || grid[r][c]==0) return 0;

        grid[r][c]=0; //방문 표시 (재방문 방지)

        //현재 칸(1) + 상하좌우 넓이 합산
        return 1+dfs(r+1,c,grid)+dfs(r-1,c,grid)+dfs(r,c+1,grid)+dfs(r,c-1,grid);
    }


}

/*
4방향으로 왔다갔다
*/