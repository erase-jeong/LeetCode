class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //정답 선언
        List<Integer> ans=new ArrayList<>();    

        int m=matrix.length;  //세로
        int n=matrix[0].length; //가로
        int top=0, bottom=m-1;
        int left=0, right=n-1;
        
        while(top<=bottom && left<=right){
            //오른쪽 : r=top 고정, c:left-> right{}
            for(int c=left;c<=right;c++){
                ans.add(matrix[top][c]);
            }
            top++;  //이 중간에라도 while문 조건 만족못하면 나가리? 
            
            //아래 : c=right 고정, r:top->bottom
            for(int r=top;r<=bottom;r++){
                ans.add(matrix[r][right]);
            }
            right--;

            if(top<=bottom){  //왼쪽 : 
                for(int c=right;c>=left;c--){
                    ans.add(matrix[bottom][c]);
                }
                bottom--;
            }
            
            
            if(left<=right){  //위 :
                for(int r=bottom;r>=top;r--){
                    ans.add(matrix[r][left]);
                }
                left++;
            } 
        }

        return ans;
    }
}

