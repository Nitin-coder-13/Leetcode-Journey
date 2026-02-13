package Backtracking;
import java.util.*;
public class Word_Search {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        String word=sc.next();
     char[][] board=new char[m][n];
     for(int i=0;i<board.length;i++){
         String s=sc.next();
         for(int j=0;j<s.length();j++){
             board[i][j]=s.charAt(j);
         }
     }
     for(int i=0;i<board.length;i++){
         for(int j=0;j<board[i].length;j++){
             if(word.charAt(0)==board[i][j]){
                boolean ans= word_exist(board,word,i,j,0);
                 if (ans) {
                     System.out.println(ans);
                     return;
                 }
             }
         }

     }
     System.out.println(false);
    }
    public static boolean word_exist(char[][] board,String word,int current_row,int current_column,int index_of_word){
        if(word.length()==index_of_word){
            return true;
        }
        if(current_row<0 || current_column<0 || current_row>=board.length || current_column>=board[0].length|| word.charAt(index_of_word)!=board[current_row][current_column]) {
            return false; // returns from the function frame.
        }
        board[current_row][current_column]='*'; // marked the position so that it can't be used further
        int[] row={-1,1,0,0};
        int[] col={0,0,-1,1};
        for(int i=0;i<row.length;i++){
            boolean ans_=word_exist(board, word,current_row+row[i],current_column+col[i],index_of_word+1);
            if(ans_){
                return true;
            }
        }
        board[current_row][current_column]=word.charAt(index_of_word); // undo
        return false;
    }


}
