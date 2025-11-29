package Arrays;
import java.util.Scanner;
public class Search_Two_D_matrix {
    public static void main(String[] args) {
      int[][] arr=new int[1][2];
      int target;
      Scanner in=new Scanner(System.in);
      for(int i=0;i<arr.length;i++){
          for(int j=0;j<arr[i].length;j++){
              arr[i][j]=in.nextInt();
          }
      }
      System.out.println("enter the target: ");
          target=in.nextInt();
          boolean result=search_stair_case(arr,target);
          System.out.println(result);
    }
    public static boolean search_stair_case(int[][] arr,int target){// stair-case approach
        int row=0;
        int col=arr[row].length-1;
        while(row<arr.length && col>=0){
            if(arr[row][col]==target){
                return true;
            } else if (arr[row][col]<target) {
                row++;
            }else {
                col--;
            }
        }
        return false;
    }
}



