package Arrays;
import java.util.Arrays;
import java.util.Scanner;
public class Aggressive_Cows {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            int noc = in.nextInt(); // number of cows
            int nos = in.nextInt(); // number of stalls
            int[] stall = new int[nos]; // array of stalls
            for (int i = 0; i < stall.length; i++) {
                stall[i] = in.nextInt();
            }
            Arrays.sort(stall);
            int result = min_distance(stall, noc);
            System.out.println(result);
        }
    }
    public static int min_distance(int[] stall,int noc){
        int low=stall[0];
        int high=stall[stall.length-1];
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(is_it_possible(stall,noc,mid)==true){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static boolean is_it_possible(int[] stall, int noc,int mid){
        int pos=stall[0]; // assume one cow we already seated at first position
        int cows_count=1;
        for (int i = 1; i <stall.length ; i++) {
            if(stall[i]-pos>=mid){
                cows_count++;
                pos=stall[i]; // because now we will compare the cow with the new sitting position of cow
            }
            if(cows_count==noc){
                return true;
            }
        }
        return false;
    }
}
