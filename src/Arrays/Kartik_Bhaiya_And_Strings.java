package Arrays;
import java.util.Scanner;
import java.lang.Math;
public class Kartik_Bhaiya_And_Strings {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int k=in.nextInt();
        String s=in.next();
        int flip_a=string_perfectness(s,'a',k);
        int flip_b=string_perfectness(s,'b',k);
        int final_ans=Math.max(flip_a,flip_b);
        System.out.println(final_ans);
    }
    public static int string_perfectness(String s,char c1,int k){
        int si=0;
        int ei=0;
        int flip=0;
        int ans=0;
        while(ei<s.length()){
            if(s.charAt(ei)==c1){
                flip++;
            }
            while(flip>k && si<=ei){
                if(s.charAt(ei)==c1){
                    flip--;
                }
                si++;
            }
            ans=Math.max(ei-si+1,ans);
            ei++;
        }
        return ans;
    }
}
