package BitWise;

/**
 * Created by shli15 on 7/28/16.
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        // Write your code here
        int lenA = a.length();
        int lenB = b.length();
        int len = lenA;
        int carry = 0;
        int sum = 0;
        String rst = "";

        if (lenA < lenB) {
            a = padding(a, b);
            len = lenB;
        } else if (lenB < lenA) {
            b = padding(b, a);
            len = lenA;
        }

        for (int i = len - 1; i >= 0; i--) {
            int left = a.charAt(i) - '0';
            int right = b.charAt(i) - '0';
            sum = left ^ right ^ carry;
            rst = Integer.toString(sum) + rst;

            carry = (left & right) | (left & carry) | (right & carry);
        }

        if (carry > 0) {
            return "1" + rst;
        }

        return rst;
    }

    private static String padding(String shortVal, String longVal) {
        int diff = longVal.length() -  shortVal.length();
        for (int i = 0; i < diff; i++) {
            shortVal = "0" + shortVal;
        }

        return shortVal;
    }

    public static void main(String[] args) {
        String a = "11", b = "1";
        String rst = AddBinary.addBinary(a, b);
        System.out.print(rst);
    }
}
