import java.util.*;

class Solution {
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};

    public int orangesRotting(int[][] grid) {
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> q=new LinkedList<>();
        int time=0, fresh=0;

        int rows=grid.length, cols=grid[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1) fresh+=1;
                if(grid[r][c]==2) q.add(new int[]{r,c});
            }
        }

        while(!q.isEmpty() && fresh>0){
            int size=q.size(); //현재 들어있는 오렌지 개수만큼만 전파
            for(int i=0;i<size;i++){
                int[] orange=q.poll();
                int r=orange[0];
                int c=orange[1];

                for(int d=0;d<4;d++){
                    int nr=r+dr[d];
                    int nc=c+dc[d];

                    if(nr<0 || nr==grid.length || nc<0 || nc==grid[0].length || grid[nr][nc]!=1) continue;
                    grid[nr][nc]=2;
                    q.add(new int[]{nr,nc});
                    fresh-=1;
                }
            }
            time++; //for문 밖으로 
        }

        if(fresh==0) return time;
        else return -1;
    }
}
