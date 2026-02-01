package Recursion;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Lexicographical_Numbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> l1 = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 1; i <= 9; i++) {
            print_lexico(i, n, l1);
        }
        System.out.print(l1+" ");
    }
        public static void print_lexico(int current,int end, List<Integer> l1){
            if(current>end){
                return;
            }
            l1.add(current);
            int i=0;
            for(;i<=9;i++){
                print_lexico((current*10)+i,end,l1);
            }
        }
    }

