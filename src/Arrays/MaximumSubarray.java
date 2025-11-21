package Arrays;
import java.lang.Math;
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
     System.out.println(maximum_sub_array(arr));
    }
    public static int maximum_sub_array(int[] arr){
        int ans=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            ans=Math.max(sum,ans);
            // negative numbers are our enemy, reset the sum to 0!
            if(sum<0){
                sum=0;
            }
        }
        return ans;
    }
}
