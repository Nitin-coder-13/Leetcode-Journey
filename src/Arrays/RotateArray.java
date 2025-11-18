import java.util.Scanner;
import java.util.Arrays;
public class rotatearrayoptimized {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("enter array length: ");
        int n;
        n=in.nextInt();
        System.out.println("enter the value of k: ");
        int k=in.nextInt();
        k=k%n;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        rotate_array(arr,k,n);
        System.out.println(Arrays.toString(arr));

    }
    public static void rotate_array(int[] arr,int k,int n){
        reverse(arr,0,n-k-1);
        reverse(arr,n-k,n-1);
        reverse(arr,0,n-1);
    }
    public static void reverse(int[] arr,int i, int j){
        int temp;
        while(i<j){
            temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }

    }
}
