package Backtracking;
import java.util.*;

public class Combinations {
    public static void main(String[] args) {
        int n=4;
        int k=2;
        List<Integer> l1=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        ways_combination(n,k,l1,ans,1);
        System.out.print(ans+" ");
    }
    public static void ways_combination(int n,int k,List<Integer> l1, List<List<Integer>> ans,int index_tracker){
        if(l1.size()==k){
            ans.add(new ArrayList<>(l1));
            return;
        }
        for(int i=index_tracker;i<=n;i++){
            l1.add(i);
            ways_combination(n, k, l1, ans, i+1);
            l1.remove(l1.size()-1);
        }

    }

}
