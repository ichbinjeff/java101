package Search;
import java.util.ArrayList;
/**
 * Created by shli15 on 11/5/16.
 */
public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        helper(result, "", "", n, n);
        return result;

    }

    public void helper(ArrayList<String> result,
                       String padding,// current paren
                       String paren,
                       int left,     // how many left paren we need to add
                       int right) {  // how many right paren we need to add
        System.out.println(padding + "helper" + String.valueOf(left) + "," +  String.valueOf(right) + "\n");

        if (left == 0 && right == 0) {
            result.add(paren);
            return;
        }

        if (left > 0) {
            helper(result, padding + "   ", paren + "(", left - 1, right);
        }

        if (right > 0 && left < right) {
            helper(result, padding + "   ", paren + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses GP = new GenerateParentheses();
        GP.generateParenthesis(2);
        System.out.print("haha");
        String abc = "abc";
        String rst = "efg" + abc.charAt(2);
        System.out.print(rst);
    }
}
