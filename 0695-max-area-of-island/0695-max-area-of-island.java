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
                    int area=bfs(r,c,grid);
                    maxArea=Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }

    public int bfs(int r, int c, int[][] grid){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{r,c});
        grid[r][c]=0;
        int area=0;

        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            area++;

            for(int[] d:dirs){
                int nr=cur[0]+d[0];
                int nc=cur[1]+d[1];
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]==1){
                    grid[nr][nc]=0;
                    queue.add(new int[]{nr,nc});;
                }
            }
        }
        return area;
    }


}
