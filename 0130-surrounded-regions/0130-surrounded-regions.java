import java.util.*;

class Solution {
    static int rows;
    static int cols;

    public void solve(char[][] board) {
        rows=board.length;
        cols=board[0].length;

        //1단계 : 가장자리 O에서 DFS
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if((r==0 || r==rows-1 || c==0 || c==cols-1) && board[r][c]=='O') dfs(r,c,board);
            }
        }

        //2단계 : 변환
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c]=='O') board[r][c]='X'; //캡쳐
                else if(board[r][c]=='S') board[r][c]='O'; //복원
            }
        }
    }

    
    public static void dfs(int r, int c, char[][] board){
        if(r<0 || r>=rows || c<0 || c>=cols || board[r][c]!='O') return;
        board[r][c]='S'; //살아남을 S표시
        dfs(r+1, c,board);
        dfs(r-1,c,board);
        dfs(r,c+1,board);
        dfs(r,c-1,board);       
    }


}
