package misc;

/**
 * Created by shli15 on 8/1/16.
 */
public class BigNumber {
    public String mul(String a, String b) {
        int rst = 0;
        //123
        // 25

        // 3 * 5 * 10^0 + 3 * 2 * 10^1
        // 2 * 10 * 5

        int firstCount = 0;
        for(int i = a.length() - 1; i >= 0; i--) {
            int secondCount = 0;
            for (int j = b.length() - 1; j >= 0; j--) {

                int num1 = a.charAt(i) - '0';
                int num2 = b.charAt(j) - '0';


                secondCount ++;
            }
            firstCount ++;
        }

        return Integer.toString(rst);
    }

    //1234
    //3456


    public String multiply(String a, String b) {
        int [] rst = new int[a.length() + b.length() - 1];
        int[][] table = new int[a.length()][b.length()];
        for (int i = a.length() - 1; i >= 0; i--) {
            for (int j = b.length() - 1; j >= 0; j--) {
                int num1 = a.charAt(i) - '0';
                int num2 = b.charAt(j) - '0';
                table[i][j] = num1 * num2;
            }
        }

        int k = 0;
        while (k < a.length() + b.length() - 1) {
            for (int i = 0; i < a.length(); i++) {
                for (int j = 0; j < b.length(); j++) {
                    if (i + j == k) {
                        rst[k] += table[i][j];
                    }
                }
            }
            k ++;
        }

        String rststr = "";
        int carry = 0;
        for (int i = rst.length - 1; i >= 0; i--) {
             int sum = rst[i] + carry;
             int num = sum % 10;
             carry = sum / 10;

             rststr = Integer.toString(num) + rststr;
        }

        if (carry > 0) {
            rststr = Integer.toString(carry) + rststr;
        }

        return rststr;
    }

    //123
    // 23
    public String add(String a, String b) {
        int carry = 0;
        int len = a.length();
        String rst = "";

        if (a.length() < b.length()) {
            a = padding(a, b);
            len = b.length();
        } else if (a.length() > b.length()) {
            b = padding(b, a);
            len = a.length();
        }

        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[i] = a.charAt(i) - '0' + b.charAt(i) - '0';
        }

        for (int i = temp.length - 1; i >= 0; i--) {
            int sum = temp[i] + carry;
            int num = sum % 10;
            carry = sum / 10;

            rst = Integer.toString(num) + rst;
        }

        if (carry > 0) {
            rst = Integer.toString(carry) + rst;
        }

        return rst;
    }

    public String padding(String shortStr, String longStr) {
        int diff = longStr.length() - shortStr.length();
        for (int i = 0; i < diff; i++) {
            shortStr = '0' + shortStr;
        }

        return shortStr;
    }

    public static void main(String[] args) {
        BigNumber BN = new BigNumber();
        String rst = BN.multiply("2342345", "123438940234083432");
        String rstadd = BN.add("1003840238490823904890234234","9234243242343");
        System.out.print(rst);
    }

}
