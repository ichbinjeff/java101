package Search;

/**
 * Created by shli15 on 12/11/16.
 */
public class RecursivePolishNotation {
    private int index;
    public int evalRPN(String[] tokens) {
        index = tokens.length-1;
        return helper(tokens);
    }

    private int helper(String[] tokens) {
        String op = tokens[index];
        if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
            index --;
            int v1 = helper(tokens);
            index --;
            int v2 = helper(tokens);
            if (op.equals("+")) {
                return v1 + v2;
            } else if (op.equals("-")) {
                return v2 - v1;
            } else if (op.equals("*")) {
                return v1 * v2;
            } else {
                return v2 / v1;
            }
        } else {
            return Integer.valueOf(op);
        }
    }

    public static void main(String[] args) {
        RecursivePolishNotation RPN = new RecursivePolishNotation();
        String[] tst = new String[] {"0","3","/"};
        int rst = RPN.evalRPN(tst);
        System.out.print(rst);
    }
}
