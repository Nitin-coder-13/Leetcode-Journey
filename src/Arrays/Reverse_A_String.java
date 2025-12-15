package Arrays;

public class Reverse_A_String {
    public static void main(String[] args) {
     String s="the sky is blue";
     String result=reverse(s);
     System.out.println(result);
    }
    public static String reverse(String s){
        s=s.trim();
        String[] arr=s.split("\\s+");
        String ans="";
        for(int i=arr.length-1;i>=0;i--){
            ans+=arr[i]+ " ";
        }
        return ans.trim();
    }
}
