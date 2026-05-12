class Solution {
    static int[] dr={1,-1,0,0,   1,-1,1,-1};
    static int[] dc={0,0,1,-1,   1,1,-1,-1};

    static int m;
    static int n;

    public void gameOfLife(int[][] board) {
        n=board.length; //세로(행)
        m=board[0].length; //가로(열)

        int[][] temp=new int[n][m];

        //board -> temp
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==1){
                    //살아있는 세포 2개 미만
                    if(LiveCnt(i,j,board)<2) temp[i][j]=0; 

                    //살아있는 세포 2~3개
                    else if(LiveCnt(i,j,board)==2 || LiveCnt(i,j,board)==3) temp[i][j]=1;
                    
                    //살아있는 세포 3개 이상
                    else if(LiveCnt(i,j,board)>3) temp[i][j]=0;
                
                }else if(board[i][j]==0){
                    //죽은세포=> 살아있는 세포 3개 인접
                    //(Live)
                    if(LiveCnt(i,j,board)==3) temp[i][j]=1;
                }

       
            }
        }

        //temp -> board
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j]=temp[i][j];
            }
        }
            




        
    }

    public static int LiveCnt(int r, int c, int[][] board){
        int cnt=0; 
        for(int d=0;d<8;d++){
            int nr=r+dr[d];
            int nc=c+dc[d];
            if(0<=nr && nr<n && 0<=nc && nc<m){
                if(board[nr][nc]==1) cnt++;
            } 
            
        }
        return cnt;
    }

    /*
    public static int DeadCnt(int r, int c, int[][] board){
        int cnt=0;



        return cnt; 
    }
    */
}

/*
생존 : 1
사망 : 0

주변에 살아있는 세포가 2개 미만 -> 개체수 부족 => 죽은 것처럼 보임

살아있는 세포 3개 이상 => 죽은것처럼 보인
*/