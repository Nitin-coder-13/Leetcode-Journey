package Arrays;
import java.lang.Math;
public class FirstBadVersion {
    public static void main(String[] args) {
    System.out.println(first_bad_version(87,3));
    }
    public static int first_bad_version(int n,int k){
        int low=1;
        int high=n;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(Math.pow(mid,k)<=n){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return (ans+1);
    }
}
