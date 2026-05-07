import java.util.*;
class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int[][] ans=new int[n][n];
        
        for(int i=0;i<n;i++){
            //System.out.println("i : "+i);
            for(int j=n-1;j>=0;j--){
                //System.out.println("["+j+"]["+i+"] :"+matrix[j][i]);
                //System.out.print(matrix[j][i]+" ");
                ans[i][n-1-j]=matrix[j][i];
            }
            System.out.println();
        }

        System.out.println();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(ans[i][j]+" ");
                matrix[i][j]=ans[i][j];
            }
            System.out.println();
        }

        //return ans;


    }
} 

/*
0 과 n-1  -> 두개 합쳐서 n-1
n-1-j
*/