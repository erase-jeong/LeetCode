class Solution {
    //상하좌우, 대각선
    static int[] dx={0,0,-1,1, -1,-1,1,1};
    static int[] dy={-1,1,0,0,-1,1,-1,1};
    static int n;
    static int m;

    public void gameOfLife(int[][] board) {
        n=board.length;
        m=board[0].length;

        int[][] tmp=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==1){
                    if(nearBy(i,j,board)<2) tmp[i][j]=0;
                    else if(nearBy(i,j,board)==2 || nearBy(i,j,board)==3) tmp[i][j]=1;
                    else if(nearBy(i,j,board)>3) tmp[i][j]=0;
                    else tmp[i][j]=tmp[i][j];
                }else{
                    if(nearBy(i,j,board)==3) tmp[i][j]=1;
                    else tmp[i][j]=tmp[i][j];
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j]=tmp[i][j];
            }
        }

    }

    public static int nearBy(int x,int y,int[][] board){
        //현재위치(x,y)를 기준으로 8방향 탐색해서 몇개가 1인지 찾는거
        //근데 이거 동시에 되는거니깐 한번 넣고 복사해서 다시 넣어야 할듯?
        int count=0;

        for(int d=0;d<8;d++){
            int nx=x+dx[d];
            int ny=y+dy[d];
            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
            if(board[nx][ny]==1) count++; //이거 왜 안되는거지?
        }

        return count;
    }
}