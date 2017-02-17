package misc;

/**
 * Created by shli15 on 10/12/16.
 */
public class CountSay {
    public String countAndSay(int n) {
        // Write your code here
        //11
        String curr = "1";

        for (int i = 1; i <= n; i++) {
            curr = countSay(curr);
        }

        return curr;
    }

    public String countSay(String curr) {
        char[] currArr = curr.toCharArray();

        StringBuilder sb = new StringBuilder();
        int count = 1;
        String number = String.valueOf(currArr[0]);
        String prevNumber = String.valueOf(currArr[0]);

        for (int i = 1; i < currArr.length; i++) {
            number = String.valueOf(currArr[i]);
            if (prevNumber.equals(number)) {
                count ++;
            } else {
                sb.append(count);
                sb.append(prevNumber);
                count = 1;
            }

            prevNumber = number;
        }

        sb.append(count);
        sb.append(number);

        return sb.toString();
    }

    public static void main(String[] args) {
        CountSay cs = new CountSay();
        String rst = cs.countSay("1211");
        String a = cs.countAndSay(2);
        System.out.print(rst);
    }
}
