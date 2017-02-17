package Array;

/**
 * Created by jli on 4/12/16.
 */
public class CountAndSay {
    // aaaabb
    // ab
    public String countAndSay(String input) {
        char[] charArr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i - 1] == charArr[i]) {
                count ++;
            } else {
                sb.append(charArr[i - 1]);
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
            }
        }
        sb.append(charArr[charArr.length - 1]);
        if (count > 1) {
            sb.append(count);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String tst = "aaaaabbbccccde";
        CountAndSay cs = new CountAndSay();
        String rst = cs.countAndSay(tst);
        System.out.print(rst);
    }
}
