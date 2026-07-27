class Solution {
    
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static int[][] temp;
    static int[][] visited;

    public void solve(char[][] board) {
        temp=new int[board.length][board[0].length];
        visited=new int[board.length][board[0].length];

        //테두리 훑기
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0 || i==board.length-1 || j==0 || j==board[0].length-1){
                    //bfs();
                    if(board[i][j]=='O'){
                        //temp[i][j]=1;
                        bfs(i,j,board, temp);
                    }

                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(temp[i][j]==1) board[i][j]='O';
                else board[i][j]='X';
            }
        }

    }

    public void bfs(int i, int j, char[][] board, int[][] temp){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{i,j});
        //board[i][j]='X';
        temp[i][j]=1;
        visited[i][j]=1;

        while(!queue.isEmpty()){
            int[] p=queue.poll();
            for(int d=0;d<4;d++){
                int nr=p[0]+dr[d];
                int nc=p[1]+dc[d];

                if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length
                && board[nr][nc]=='O' && visited[nr][nc]==0){
                    queue.add(new int[]{nr,nc});
                    //board[nr][nc]='X';
                    temp[nr][nc]=1;
                    visited[nr][nc]=1;
                }
            }
        }

    }
}

/*
둘러싸임 여부 판단 (가장자리 닿으면 제외)
bfs로 풀기
*/

/*
"둘러싸인 O를 찾지 말고, 반대로 테두리에 붙어있는 O(=절대 안 바뀌는 O)를 먼저 다 찾아서 표시해라. 그리고 남은 O만 X로 바꿔라."
*/