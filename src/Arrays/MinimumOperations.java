package Arrays;

public class MinimumOperations {
    public static void main(String[] args) {
        int[] arr={3,6,9};
   System.out.println(operations(arr));
    }
    public static int operations(int[] arr){
        int i;// arr=[1,2,3,4]
        int count=0;
        for(i=0;i<arr.length;i++){
           if(arr[i]%3!=0){
               count++;
           }

        }
         return count;
    }
}
