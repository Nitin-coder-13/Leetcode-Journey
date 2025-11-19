package Arrays;
import java.util.Arrays;
public class ArrayExceptSelf {
    public static void main(String[] args) {
     int[] arr={-1,1,0,-3,3};
     int[] result=productself(arr);
     System.out.println("The array is: "+Arrays.toString(result));
    }
    public static int[] productself(int[] nums){
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=1;
        for(int i=1;i<n;i++){
          left[i]=left[i-1]*nums[i-1];

        }
        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }
        for(int i=0;i<n;i++){
            nums[i]=left[i]*right[i];
        }
        return nums;
    }
}
