package recursion;

public class Palindrome {

    private static boolean isAPalindrome(String s) {

        //base case 1
        if (s.length() <= 1) {
            return true;
        }

        //base case 2
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        //recursive case
        return isAPalindrome(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(isAPalindrome("rotor"));
        System.out.println(isAPalindrome("g"));
        System.out.println(isAPalindrome(""));
        System.out.println(isAPalindrome("motor"));
    }

}
