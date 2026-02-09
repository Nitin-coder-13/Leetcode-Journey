package Backtracking;
import java.util.*;
public class Combination_Sum_3 {
    public static void main(String[] args) {
        int target=1;
        int k=4;
        List<Integer> l1=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        combinations(target,k,l1,ans,1);
        System.out.print(ans+" ");
    }
    public static void combinations(int target_left,int k,List<Integer> l1,List<List<Integer>> ans,int index_tracker){
        if(target_left==0 && l1.size()==k){
            ans.add(new ArrayList<>(l1));
            return;
        }
        for(int i=index_tracker;i<=9;i++){
            l1.add(i);
            combinations(target_left-i,k,l1,ans,i+1);
            l1.remove(l1.size()-1);
        }
    }
}
