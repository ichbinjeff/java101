package String;

import LinkedList.Reverse;

/**
 * Created by shli15 on 11/29/16.
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0 || s.trim().equals("")) {
            return "";
        }
        int start = 0;
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != ' ' && i < sArr.length - 1) {
                continue;
            } else if (i < sArr.length - 1){
                reverse(start, i - 1, sArr);
                start = i + 1;
            } else {
                reverse(start, i, sArr);
            }
        }
        reverse(0, sArr.length - 1, sArr);
        return new String(sArr);
    }

    private void reverse(int start, int end, char[] sArr) {
        while (start < end) {
            char temp = sArr[start];
            sArr[start] = sArr[end];
            sArr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseWords RW = new ReverseWords();
        String rst = RW.reverseWords("I like you");
        System.out.print(rst);
    }
}
