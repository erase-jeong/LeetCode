import java.util.*; 

class Solution {
    static int rows, cols;

    public int numIslands(char[][] grid) {
       //행, 열
       rows=grid.length;
       cols=grid[0].length;

        int count=0;

       //bfs 순회
       //덩어리 출력하기
       for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]=='1'){
                    count+=bfs(r,c,grid);
                }
            }
       }

       return count;
    }

    public static int bfs(int r, int c, char[][] grid){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{r,c});
        grid[r][c]='0';

        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            
            for(int[] d:dirs){
                int nr=cur[0]+d[0];
                int nc=cur[1]+d[1];

                if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]=='1'){
                    grid[nr][nc]=0;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
        return 1;
    }
}