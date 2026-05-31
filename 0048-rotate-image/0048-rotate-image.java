class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        int[][] tmp=new int[n][n];
        //1st. 행,열 바꾸기
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                tmp[i][j]=matrix[j][i];
            }
        }
        //확인용 출력
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(tmp[i][j]);
            }
            System.out.println();
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=tmp[i][n-1-j];
            }
        }

    }
}