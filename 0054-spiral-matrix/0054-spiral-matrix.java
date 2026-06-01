class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //정답
        List<Integer> ans=new ArrayList<>();

        int n=matrix.length; //가로
        int m=matrix[0].length; //세로
        int top=0, bottom=n-1;
        int left=0, right=m-1;

        int dir=0;

        while(top<=bottom && left<=right){
            
            if(dir==0){ //오른쪽으로
                for(int i=left;i<=right;i++){
                    ans.add(matrix[top][i]);
                }
                top++;

            }else if(dir==1){
                for(int i=top;i<=bottom;i++){
                    ans.add(matrix[i][right]);
                }
                right--;

            }else if(dir==2){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;

            }else if(dir==3){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                left++;

            }

            dir=(dir+1)%4;
            
        }

        return ans;

    }
}