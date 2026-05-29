package DynamicProgramming;

// Same as LCS
public class Uncrossed_Lines {
    public static void main(String[] args) {
        int[] arr1={1,4,2};
        int[] arr2={1,2,4};
        System.out.println(max_BU(arr1,arr2));
    }
    // Bottom Up Approach
    public static int max_BU(int[] nums1,int [] nums2){
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    int a=dp[i-1][j];
                    int b=dp[i][j-1];
                    dp[i][j]=Math.max(a,b);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
