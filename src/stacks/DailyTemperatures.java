package Stacks;
import java.util.Stack;
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures={30,40,50,60};
     int[] result=daily_temp(temperatures);
     for(int i:result){
         System.out.print(i+" ");
     }
    }
    public static int[] daily_temp(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                int idx=st.pop();
                ans[idx]=i-idx;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            ans[st.pop()]=0;
        }
        return ans;
    }
}
