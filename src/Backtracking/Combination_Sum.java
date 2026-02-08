package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
    public static void main(String[] args) {
        int[] candidates={2,3,5};
        int target=8;
        List<Integer> l1=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
       ways(candidates,l1,target,0,ans);
       System.out.print(ans+" ");
    }
    public static void ways(int[] candidates,List<Integer> l1,int target_left,int index_tracker,List<List<Integer>> ans){
        if(target_left==0){
            ans.add(new ArrayList<Integer>(l1));
            return;
        }
        for(int i=index_tracker;i<candidates.length;i++){
            if(target_left>=candidates[i]){
                l1.add(candidates[i]);
                ways(candidates,l1,target_left-candidates[i],i,ans);
               l1.remove(l1.size()-1);
            }
        }
    }
}
