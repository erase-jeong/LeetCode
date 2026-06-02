class Solution {
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int minutes=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2) q.add(new int[]{i,j,0});
            }
        }

        while(!q.isEmpty()){
            int[] p=q.poll();
            int time=p[2];
            minutes=Math.max(minutes,time);

            for(int d=0;d<4;d++){
                int nx=p[0]+dx[d];
                int ny=p[1]+dy[d];

                if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]==1){
                    grid[nx][ny]=2; //퍼트리기
                    q.add(new int[]{nx,ny,time+1});
                }
            }
        }

        //신선한 오렌지가 남아있으면 -1
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) return -1;
            }
        }

        return minutes;
    }
}

/*
0->empty -> 고려안함
1->fresh
2->rotten => 이거 기준으로 퍼트리기

한개만 하는게 아니라, 실시간으로 여러개 퍼트린다.

*종료조건 : fresh(1)이 없을 때까지
1. 현재단게에서 썩은 토마토들을 queue에 넣는다.
2. queue에 있는 것들은, queue가 빌때까지 순회하면서 퍼트린다.
*/