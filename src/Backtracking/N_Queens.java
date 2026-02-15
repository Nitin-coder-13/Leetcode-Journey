package Backtracking;

public class N_Queens {
    public static void main(String[] args) {
     int n=4;
     boolean[][] maze=new boolean[n][n];
     Queens_sitting(maze,0,n);
    }

    public static void Queens_sitting(boolean[][] board, int current_row, int total_queens) {
        if(total_queens==0){
          Display(board);
          return;
        }
        for (int current_col = 0; current_col < board.length; current_col++) {
            if (is_it_safe(board, current_row,current_col)) {
                board[current_row][current_col] = true;
                Queens_sitting(board,current_row+1,total_queens-1);
                board[current_row][current_col] = false;
            }
        }
    }
    // for checking the validity of sitting of queens.
    public static boolean is_it_safe(boolean[][] board, int current_row, int current_col) {
        int r= current_row;
        int c= current_col;
       while(r>=0){
           if (board[r][c]==true){ // for upward
               return false;
           }
           r--;
       }
       r=current_row;
       c=current_col;
       while(r>=0 && c>=0){
           if (board[r][c]==true){ // for left diagonal
               return false;
           }
           r--;
           c--;
       }
       r=current_row;
       c=current_col;
       while(r>=0 && c<board.length){ // right diagonal
           if (board[r][c]==true){
               return false;
           }
           r--;
           c++;
       }
       return true;
    }
    public static void Display(boolean[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}