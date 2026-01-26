package Recursion;
import java.util.ArrayList;
import java.util.List;
public class Generate_Parenthesis {
    public static void main(String[] args) {
        int n=3;
        List<String> l1=new ArrayList<>();
       parenthesis(n,0,0,"",l1);
       System.out.println(l1);
    }
   public static void parenthesis(int n,int open, int close, String ans,List<String> l1){
        // base case
       if(open==n && close==n){
           l1.add(ans);
           return;
       }
        if(open<n){
            parenthesis(n,open+1,close,ans+"(",l1);
        }
        if(close<open){
            parenthesis(n,open,close+1,ans+")",l1);
        }

   }
}
