package Arrays;
import java.lang.Math;
public class Subarray_Product_LessThanK {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int k = 0;
        int result=subarray_product(arr,k);
         System.out.println(result);
    }
    public static int subarray_product(int[] nums,int k){
        int si=0;
        int ei=0;
        int count=0;
        int product=1;
        while(ei<nums.length){
            // grow
            product*=nums[ei];
            while (product>=k && si<=ei){
                // shrink
                product/=nums[si];
                si++;
            }
            // ans update
            count+=(ei-si)+1;
            ei++;
        }
        return count;
    }
}
