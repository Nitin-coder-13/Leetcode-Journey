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
        boolean result=  search_target(arr,target);
        System.out.println(result);
    }

    public static boolean search_target(int[][] matrix,int target){
        for(int i=0;i<matrix.length;i++){
            int low=0;
            int high=matrix[i].length-1;
                while(low<=high){
                    int mid=low+(high-low)/2;
                    if(matrix[i][mid]==target){
                        return true;
                    } else if (matrix[i][mid]<target) {
                        low=mid+1;
                    }else{
                        high=mid-1;
                    }
                }
            }

        return false;
    }
}
