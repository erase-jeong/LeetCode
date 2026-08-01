class Solution {
    //움직이는 방향대로 배열을 선언한다
    //오른쪽 , 아래, 왼쪽, 위쪽
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

/*
현재 방향을 순회를 다하고 나면, 이젠 다음 방향으로 순회한다. 

방향을 옆으로 돌아가면서 돌린다. 
다 채울때까지 다 차고나면 이제 다음로직으로 돌아간다

방향을 다 채우고나면, 그 다음에 돌리는 로직을 처리한다.
어떻게?
=> 잘 처리한다.
=> 옆으로 돌린다.
다 갔다는걸 어떻게 아는가? => left, right 다 갔을때 기준으로 다 갔는지 유무를 체크한다.

다 갔는지 유무를 체크한다.
다 갔으면 방향을 돌린다.
방향을 돌리고, 
다 갔으면, 자기자신으로 한번 back하면서 돌아오는 로직을 거쳐야한다.
다 갔는지 확인하기위해서는 매번 반복문안에서 다 갔는지 유무를 체크할 것인가?
=> 그게 아니라면 어떻게 체크할 것인지?
=> 일단 다 갔다가 하는 방식에 대해서 어떻게 하는 것이 더 좋을지에 대해서 고민해봐야한다

다 돌고, 다 간다음에 한번 더 갈수도 있니?
*/