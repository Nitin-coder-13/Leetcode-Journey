package Backtracking;
import java.util.*;
public class Palindrome_Partition {
    public static void main(String[] args) {
     String ques="aab";
     List<String> ans=new ArrayList<>();
     List<List<String>> ans2=new ArrayList<>();
     palindrome(ques,ans,ans2);
     System.out.print(ans2+" ");
    }
    public static void palindrome(String ques,List<String> ans, List<List<String>> ans2){
        if(ques.length()==0){
            ans2.add(new ArrayList<>(ans));
            return;
        }
        for(int i=1;i<=ques.length();i++){
            String ans_part=ques.substring(0,i);
            if( palindrome_check(ans_part)) { // for checking the palindrome of the cut part(ans_part)
                ans.add(ans_part);
                palindrome(ques.substring(i), ans,ans2);
                ans.remove(ans.size()-1);
            }
        }
    }
    public static boolean palindrome_check(String ans_part){
        int i=0;
        int j=ans_part.length()-1;
        while(i<j){
            if(ans_part.charAt(i)!=ans_part.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
