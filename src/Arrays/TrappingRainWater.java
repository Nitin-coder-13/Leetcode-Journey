package Arrays;

import java.lang.Math;
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr={4,2,0,3,2,5};
        int result=rain_trap(arr);
        System.out.println("The units of water stored is: "+result);
    }
    public static int rain_trap(int[] arr){
        int n=arr.length;
        int sum=0;
        int[] left=new int[n];
        int[] right=new int[n];
        // for left-max
        left[0]=arr[0];
        for(int i=1; i<n; i++){
            left[i]=Math.max(left[i-1],arr[i]);
        }
        // for right-max
        right[n-1]=arr[n-1];
        for(int i=n-2; i>=0; i--){
            right[i]=Math.max(right[i+1],arr[i]);
        }
        // calculating the units of water
        for(int i=0; i<n; i++){
            sum+=(Math.min(left[i],right[i]))-arr[i];
        }
        return sum;
    }
}
