class Solution {
    static int[] dr={0, 1, 0, -1}; //오른쪽, 아래, 왼쪽, 위
    static int[] dc={1, 0, -1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer=new ArrayList<>();

        int n=matrix.length;
        int m=matrix[0].length;
        boolean[][] visited=new boolean[n][m];
        int total=n*m;
        
        int r=0, c=0, d=0; 
        answer.add(matrix[0][0]); //시작 칸 먼저 처리
        visited[0][0]=true;
        int cnt=1;

        while(cnt<total){ //모든 칸을 채우면 종료 
            
            int nr=r+dr[d];
            int nc=c+dc[d];

            if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc]){
                //System.out.println("현재 r : "+r+", c : "+c);
                r=nr; //실제로 이동
                c=nc;
                answer.add(matrix[nr][nc]);
                visited[nr][nc]=true;
                cnt++;
            }else{
                d=(d+1)%4; //벽이거나 이미 방문 -> 방향 전환
            }
        }
        return answer;
    }
}

