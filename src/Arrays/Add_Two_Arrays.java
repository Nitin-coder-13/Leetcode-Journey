package Arrays;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;
public class Add_Two_Arrays {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in) ;
        int[] arr1=new int[5];
     int[] arr2=new int[6];
     System.out.println("enter the first array");
     for(int i=0;i<arr1.length;i++){
         arr1[i]=in.nextInt();
     }
     System.out.println("enter the second array: ");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i]=in.nextInt();
        }
        add_arrays_left_aligned(arr1,arr2);
        add_arrays_right_aligned(arr1,arr2);
    }
    public static void add_arrays_left_aligned(int[] arr1, int[] arr2){
        int sum=0;
        ArrayList<Integer> l1=new ArrayList<>();
        for(int i=Math.max(arr1.length,arr2.length)-1;i>=0;i--){
            int digit1=(i<arr1.length)? arr1[i]:0; // logic for right aligned addition.
            int digit2=(i<arr2.length)? arr2[i]:0;
            l1.add(0,(digit1+digit2+sum)%10);
            sum=(digit1+digit2+sum)/10;
        }
        if(sum>0){
            l1.add(0,sum);
        }
        System.out.println("the left aligned array is: " + l1);
    }
    public static void add_arrays_right_aligned(int[] arr1, int[] arr2){
        ArrayList<Integer> l1=new ArrayList<>();
        int carry=0;
        int i=arr1.length-1;
        int j=arr2.length-1;
        while(i>=0 && j>=0){
            int sum=(arr1[i]+arr2[j]+carry);
            l1.add(sum % 10);
            carry=sum/10;
            i--;
            j--;
        }
        while(i>=0){
            int sum=arr1[i]+carry;
            l1.add(sum % 10);
            carry=sum/10;
            i--;
        }
        while(j>=0){
            int sum=arr2[j]+carry;
            l1.add(sum % 10);
            carry=sum/10;
            j--;
        }
        if(carry>0){
            l1.add(carry);
        }
        System.out.print("the right_aligned array is: ");
        for(int k=l1.size()-1;k>=0;k--){
            System.out.print( l1.get(k) + " ");
        }
    }
}
