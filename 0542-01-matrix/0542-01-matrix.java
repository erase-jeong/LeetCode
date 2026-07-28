class Solution {
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length, m=mat[0].length;
        int[][] answer=new int[n][m];
        boolean[][] visited=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();

        //1) 모든 0을 시작점으로 큐에 넣기
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] p=q.poll();
            int r=p[0], c=p[1];
            //visited[r][c]=true;


            for(int d=0;d<4;d++){
                int nr=r+dr[d];
                int nc=c+dc[d];

                if(nr>=0 && nr<mat.length && nc>=0 && nc<mat[0].length && visited[nr][nc]==false){
                    answer[nr][nc]=answer[r][c]+1;
                    visited[nr][nc]=true; 
                    q.add(new int[]{nr,nc});
                }
            }
        }

        return answer;
    }


/*
    public int bfs(int r, int c, int[][] mat){
        int[][] visied=new int[mat.length][mat[0].length];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{r,c,0});
        visited[r][c]=1;

        while(!q.isEmpty()){
            int[] p=q.poll();

            for(int d=0;d<4;d++){
                int nr=p[0]+dr[d];
                int nc=p[1]+dc[d];
                int dist=p[2]+1;

                if(nr>=0 && nr<mat.length && nc>=0 && nc<mat[0].length && visited[nr][nc]==0){
                    if(mat[nr][nc]==0) return dist;
                    else{
                        q.add(new int[]{nr,nc,dist});
                        visited[nr][nc]=1;
                    }
                }

            }
        }
        return -1;  //형식상으로?
    }
    */
}