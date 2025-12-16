package Arrays;

public class Find_In_Mountain_Array {
    public static void main(String[] args) {
        int[] nums={0,1,2,4,2,1};int n=nums.length;
        int target=10;
        int peak=find_peak(nums);
       int index=find_minimum_index(nums,target,0,peak,true);
       if(index==-1){
           index=find_minimum_index(nums,target,peak+1,n-1,false);
       }
       System.out.println(index);
    }
    public static int find_peak(int[] arr){
        int low=0;
        int high=arr.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]<arr[mid+1]){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return high;
    }
    public static int find_minimum_index(int[] arr,int target,int low,int high,boolean isAscending){
       int ans=-1;
        if(isAscending){
            while(low<=high){
                int mid=low+(high-low)/2;
                if(arr[mid]==target){
                    ans=mid;
                    high=mid-1;
                } else if (arr[mid]<target) {
                    low=mid+1;
                } else{
                    high=mid-1;
                }
            }
        } else{
            while(low<=high){
                int mid=low+(high-low)/2;
                if(arr[mid]==target){
                    ans=mid;
                    high=mid-1;
                } else if (arr[mid]>target) {
                    low=mid+1;
                } else{
                    high=mid-1;
                }
            }
        }
        return ans;
    }
}
