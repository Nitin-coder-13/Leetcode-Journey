package Arrays;

public class Palindrome {
    public static void main(String[] args) {
          System.out.println(isPalindrome(111));
    }

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        if (number == 0) {
            return true;
        }
        String str = Integer.toString(number);
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
