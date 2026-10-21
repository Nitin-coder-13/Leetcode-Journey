package String;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome_("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome_(String s) {
        String lower = s.toLowerCase();// LOWER case me convert kr dia
        String nospaces = lower.replaceAll("\\s+", ""); // spaces hata dia
        StringBuilder new_ = new StringBuilder();
        for (int i = 0; i < nospaces.length(); i++) {
            if ((nospaces.charAt(i) >= 'a' &&  nospaces.charAt(i) <= 'z') || nospaces.charAt(i)>='0' && nospaces.charAt(i) <= '9') {
                new_.append(nospaces.charAt(i));
            }
        }
        return validPalindrome(new_.toString());
    }

    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
