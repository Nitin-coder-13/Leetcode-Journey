package Arrays;
import java.util.Scanner;
public class Cb_Numbers {
    public static void main(String[] args) {
    Scanner in =new Scanner(System.in);
    String s=in.next();
    int result=print_substring(s);
    System.out.println(result);
    }
    public static int print_substring(String s){
        int count=0;
        int n=s.length();
        boolean[] visited =new boolean[n];
        for(int length=1;length<=s.length();length++){
            for(int j=length;j<=s.length();j++){
                int i=j-length;
                String s1=s.substring(i,j);
                if(is_cb_number(Long.parseLong(s1))==true && is_valid(visited,i,j)==true){
                    count++;
                    for(int check=i;check<j;check++){
                        visited[check]=true;
                    }
                }
            }
        }
        return count;
    }
    public static boolean is_valid(boolean[] visited, int i, int j){
        for(;i<j;i++){
            if(visited[i]==true){
                return false;
            }
        }
        return true;
    }
    public static boolean is_cb_number(long num){ // convert that substring to number,it may result out of range for integer that's why i used long
        int[] arr={2,3,5,7,11,13,17,19,23,29};
        if(num==0 || num==1){
            return false;
        }
        for(int i=0;i<arr.length;i++){
            if(num==arr[i]){
                return true;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(num%arr[i]==0){
                return false;
            }
        }
        return true;
    }

}

