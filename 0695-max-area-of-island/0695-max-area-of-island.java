class Solution {
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    static int n,m;
    static boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        n=grid.length;
        m=grid[0].length;

        visited=new boolean[n][m];

        int answer=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    answer=Math.max(answer,bfs(i,j,grid));
                } 
            }
        }

        return answer;
    }

    public static int bfs(int x, int y, int[][] grid){
        visited[x][y]=true;
        int count=1;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] p=q.poll();
            for(int d=0;d<4;d++){
                int nx=p[0]+dx[d];
                int ny=p[1]+dy[d];
                //이 중에 뭐 하나 걸리면 낙오임
                if(nx<0 || nx>=n || ny<0 || ny>=m || visited[nx][ny]) continue;
                if(grid[nx][ny]==1){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny]=true;
                    count++;
                }                
            }
        }

        return count;
    }
}


/*
상하좌우 움직이기

덩어리들 찾아내기 => 그 중에 제일 큰걸로 출력하기
==> 계속 비교하면서 갱신로직 만들기

dfs, bfs 뭘로 풀어야 할까? 차이는 뭘까?
bfs로 풀꺼면 Queue를 통해서 상하좌우 이동하면서 넣을꺼 있는지 확인하고
하는로직으로 풀기. 해야한다.
*/