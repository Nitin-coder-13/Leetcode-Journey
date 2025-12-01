package Arrays;
import java.util.Arrays;
import java.util.Scanner;
public class Book_Allocation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while (t > 0) {
            int nob = in.nextInt(); // number of books
            int nos = in.nextInt(); // number of students
            int[] pages = new int[nob];
            for (int i = 0; i < pages.length; i++) {
                pages[i] = in.nextInt();
            }
            Arrays.sort(pages);
            int result = min_pages(pages, nos);
            System.out.println(result);
            t--;
        }
    }
    public static int min_pages(int[] pages,int nos){
        int low=0;
        int sum=0;
        int ans=0;
        int high;
        for(int i=0;i<pages.length;i++){
            sum+=pages[i];
        }
        high=sum;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(is_it_possible(pages,nos,mid)==true){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean is_it_possible(int[] pages,int nos,int mid){
        int read_page=0;
        int student_count=1;
       for(int i=0;i<pages.length;i++){
           if(read_page+pages[i]<=mid){
               read_page+=pages[i];
           }else{
               student_count++;
               read_page=pages[i];
           }
           if(student_count>nos){
               return false;
           }
       }
       return true;
    }
}
