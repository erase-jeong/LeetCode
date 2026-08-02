class Solution {
    static int n;
    static int m;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static boolean[][] visited;
    static char[][] answer;
    Queue<int[]> candidate;

    public void solve(char[][] board) {
        n=board.length;
        m=board[0].length;
        visited=new boolean[n][m];
        answer=new char[n][m];
        candidate=new LinkedList<>();

        //Arrays.fill(answer,'X');
        //System.out.println(Arrays.deepToString(answer));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                answer[i][j]='X';
            }
        }
        //System.out.println(Arrays.deepToString(answer));
        
        
        //가장자리 돌기
        for(int j=0;j<m;j++){
            if(board[0][j]=='O' && !visited[0][j]) bfs(0,j,board);
            if(board[n-1][j]=='O' && !visited[n-1][j]) bfs(n-1,j,board);
        }

        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && !visited[i][0]) bfs(i,0,board);
            if(board[i][m-1]=='O' && !visited[i][m-1]) bfs(i,m-1,board);
        }
        
        /*
        while(!candidate.isEmpty()){
            int[] p=candidate.poll();
            int r=p[0];
            int c=p[1];

            answer[r][c]='O';
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j]=answer[i][j];
            }
        }
        */

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='#') board[i][j]='O';
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }

    }

    
    public void bfs(int r, int c, char[][] board){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c]=true;
        board[r][c]='#';

        while(!q.isEmpty()){
            int[] p=q.poll();

            for(int d=0;d<4;d++){
                int nr=p[0]+dr[d];
                int nc=p[1]+dc[d];

                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && board[nr][nc]=='O'){
                    q.add(new int[]{nr,nc});
                    visited[nr][nc]=true;
                    board[nr][nc]='#';
                    //candidate.add(new int[]{nr,nc});

                }
            }


        }
    }
}

/*
3단계 절차
1. 테두리 순회 — 첫/마지막 행, 첫/마지막 열을 돌면서 'O'를 만나면 거기서 DFS/BFS 시작
2. 마킹 — 탐색으로 도달한 O를 임시 문자('#' 등)로 바꿈 = "안전 표시"
3. 전체 순회 — 'O' → 'X' (갇힌 것들), '#' → 'O' (복원)
*/

/*
정석으로 풀 것인가? 아니면 문제에 맞게 풀 것인가?
역으로 생각해서 풀 수 있는 방법도 있을꺼같은데

step1. 
가장자리 라인을 파악한다.
가장자리 라인에 o가 있으면 o를 그대로 둔다.

step2. 
가장자리가 아닌 부분에 대해서는 o가 있으면 x로 바꾼다.

=> 왜 이렇게 풀어도 되냐?

문제에서 o덩어리 찾고, 그게 x로 둘러싸이면 바꾼다고 했으니깐/
근데 가운데부분들이랑 가장자리부분이랑 연결되어있다면?

그러니깐 그러면 가장자리부분에서 o를 순회해서 4방향 순회해서 o가 있는 애들을 다 표시(따로 뭘 넣어두거나 표시)

전체 순회하면서 (이중 for문) 이 표시된 애들에 대해서는 o로 남겨두고, 그게 아니면 x로 바꾸는 로직

왜 이렇게 풀어야 하는가?
가운데에 있는 애들만 탐색하는 방법을 쓰게 되면, 뭐가 안되지?
그냥 상하좌우순회해서 o가 있는지 찾는거 뿐만 아니라, x에 둘러싸여있는지까지 파악해야함.
그럼 너무 많이 걸리고 오래걸림. 힘듦
가장자리부터 하는 방식이 더 효율적

1. visited배열 만들기 (2차원)
2. notChange 배열 만들기(2차원)  --> 없어도 됨

3. 가장자리 부분만 기준으로 메인함수에서 순회함.
    if(board[i][j]=='o] && visited[i][j]==false)

4. 함수문에서 하는 건 뭘까?
-> 여기에서는 board 전범위를 다 순회한다.
-> 그러면서 o가 있으면 더해주는 방식을 사용하는 것이다. 
-> o가 있으면 notChange 배열은 1로 해준다. -> 바로바로 board를 바꿔준다.
-> 방문여부 체크

**(?) 
바로바로 바꿔주는 방식은 별로인가? => 어차피 queue에 들어가기 때문에 바로바로 바꿔줘도 문제가 없음

*/