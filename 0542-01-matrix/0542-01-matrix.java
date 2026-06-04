class Solution {
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    static int n,m;
    static int[][] ans;

    public int[][] updateMatrix(int[][] mat) {
        int rows=mat.length;
        int cols=mat[0].length;
        int[][] dist=new int[rows][cols];
        Queue<int[]> queue=new LinkedList<>();

        //1단계 : 모든 O를 큐에 넣고, 1은 INF로 초기화
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(mat[r][c]==0){
                    dist[r][c]=0;
                    queue.offer(new int[]{r,c});
                }else{
                    dist[r][c]=Integer.MAX_VALUE;
                }
            }
        }

        //2단계 : BFS로 퍼저나가기
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int r=curr[0], c=curr[1];
            
            for(int[] dir:directions){
                int nr=r+dir[0];
                int nc=c+dir[1];

                //더 짧은 경로 발견 시 갱신
                if(nr>=0 && nr<rows && nc>=0 && nc<cols){
                    if(dist[nr][nc]>dist[r][c]+1){
                        dist[nr][nc]=dist[r][c]+1;
                        queue.offer(new int[]{nr,nc});
                    }
                }

            }
        }
        return dist;
    }
}