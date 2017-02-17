/**
 * Created by shli15 on 11/24/16.
 */
public class UnderstandChar {
    public static void main(String[] args) {
        String foo = "abcdefg";
        char[] str1 = new char[10];
        String[] str2 = new String[10];
        int index = 0;
        for (int i = 0; i < foo.length(); i++) {
            str1[index] += foo.charAt(i);
        }

        index = 0;
        char[] fooArr = foo.toCharArray();
        for (int i = 0; i < fooArr.length; i++) {
            str2[index] += fooArr[i];
        }
        System.out.print(foo.charAt(3));
        System.out.print("haha");
    }
}
