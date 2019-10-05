package javapachet;

public class ISBNexemplu {
    public static void main(String[] args) {
        String isbn = "331465242x";
        if (isValidISBN(isbn))
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }

    static boolean isValidISBN(String isbn) {
        int n = isbn.length();
        if (n != 10)
            return false;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = isbn.charAt(i) - '0';
            if (0 > digit || 9 < digit)
                return false;
            sum += (digit * (10 - i));
        }
        char last = isbn.charAt(9);
        if (last != 'x' && (last < 0 || last > 9))
            return false;
        if (last == 'x') {
            last = 10;
            sum += last;
        } else {
            sum += (last - '0');
            return (sum % 11 == 0);
        }
        return true;
    }}
