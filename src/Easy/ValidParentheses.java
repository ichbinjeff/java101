package Easy;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
/**
 * Created by shli15 on 7/16/16.
 */
public class ValidParentheses {
    public boolean isValidParanthesis(String s) {
        Map<Character, Character> store = new HashMap<Character, Character>();
        Stack<Character> stack = new Stack();
        store.put('(', ')');
        store.put('{', '}');
        store.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            if (store.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            }

            if (store.containsValue(s.charAt(i)) && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
