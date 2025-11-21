package Arrays;
import java.lang.Math;
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr={-2,0,-1};
        System.out.println(maximum_product_subarray(arr));
    }
    public static int maximum_product_subarray(int[] arr){
        int ans=Integer.MIN_VALUE;
        int product=1;
        for(int i=0;i<arr.length;i++){
            product*=arr[i];
            ans=Math.max(product,ans);
            // here 0 is our enemy, and negative numbers can be our friends!
            if(product==0){
                product=1;
            }
        }
        product=1;
        for(int i=arr.length-1;i>=0;i--){
            product*=arr[i];
            ans=Math.max(product,ans);
            if(product==0){
                product=1;
            }
        }
        return ans;
    }
}
