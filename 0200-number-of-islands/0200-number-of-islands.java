class Solution {
    static int[][] visited;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    

    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        //System.out.println("n : "+n+", m : "+m);

        visited=new int[n][m];
        //System.out.println("visited : "+Arrays.deepToString(visited));

        int answer=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'&& visited[i][j]==0){
                    System.out.println("i : "+i+", j : "+j);
                    //System.out.println("bfs 진입 : i="+i+", j="+j);
                    //bfs(i,j, grid); 
                    //answer++;
                    answer+=bfs(i,j,grid);
                } 
            }
            //System.out.println();
        }
        return answer;
    }
    
    public static int bfs(int i, int j, char[][] grid){  //bfs 1번에 하나의 덩어리를 찾아낸다
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{i,j});
        

        //System.out.println("초기 queue : " + Arrays.deepToString(queue.toArray()));

        while(!queue.isEmpty()){
            int[] p=queue.poll();
            //System.out.println("p : "+Arrays.toString(p));

            for(int d=0;d<4;d++){
                int nr=p[0]+dr[d];
                int nc=p[1]+dc[d];

                //System.out.println("nr : "+nr+", nc : "+nc);

                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1' && visited[nr][nc]==0){
                    //System.out.println("if문 내부 - nr : "+nr+", nc : "+nc);
                  //queue.add(new int{nr,nc});
                    visited[nr][nc]=1;
                    //System.out.println("visited["+nr+"]["+nc+"] :"+visited[nr][nc]);

                    queue.add(new int[]{nr,nc});
                }
            }
        }
        
        return 1;
    }


}

/*
bfs로 퍼트리면서 주변을 퍼트리면서 확인하는 로직

하는 방법
1. 방문 배열(2차원)
2. 방문하지 않았거나 1이며 방문
전체 로직 설계
*/