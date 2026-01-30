package Recursion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Letter_combination {
    static  String[] letters={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
     String ques=in.next();
     List<String> l1=new ArrayList<>();
    phone_numbers(ques,"",l1);
    System.out.println(l1);
    }
    public static void phone_numbers(String ques,String ans,List<String> l1){
        if(ques.length()==0){
           l1.add(ans);
            return;
        }
       char ch=ques.charAt(0);
       String press=letters[ch-'0'];
       for(int i=0;i<press.length();i++){
           char ch1=press.charAt(i);
           phone_numbers(ques.substring(1),ans+ch1,l1);
       }

    }
}
