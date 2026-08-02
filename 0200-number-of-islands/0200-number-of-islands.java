class Solution {
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static boolean[][] visited;

    public int numIslands(char[][] grid) {
        visited=new boolean[grid.length][grid[0].length];
        int answer=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                //bfs
                if(grid[i][j]=='1' && visited[i][j]==false){
                    answer+=bfs(i,j, grid);
                }
            }
        }

        return answer;
    }

    public int bfs(int r, int c, char[][] grid){

        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{r,c});
        visited[r][c]=true;

        while(!queue.isEmpty()){
            int[] p=queue.poll();
            
            for(int d=0;d<4;d++){
                int nr=p[0]+dr[d];
                int nc=p[1]+dc[d];

                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length 
                && grid[nr][nc]=='1' && visited[nr][nc]==false){
                    visited[nr][nc]=true;
                    queue.add(new int[]{nr,nc});
                }
            }

        }
        return 1;
    }
}


/*
전형적인 bfs문제이다.
상하좌우 퍼트려가면서, 같은 덩어리를 찾는 문제이다.
*/