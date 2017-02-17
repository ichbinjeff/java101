package Search;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * Created by shli15 on 11/30/16.
 */
public class PhoneNumberPermutation {
    public List<String> letterCombinations(String digits) {
        Map<Character, Character> map = new HashMap<Character, Character>();

        String permutateBase = "";
        for (int i = 0; i < digits.length(); i++) {
            permutateBase += map.get(digits.charAt(i));
        }
        List<String> rst = new ArrayList<String>();
        if (permutateBase.isEmpty()) return rst;
        dfs(rst, "", permutateBase);
        return rst;
    }

    private void dfs(List<String> rst, String curr, String base) {
        if (curr.length() == base.length()) {
            rst.add(curr);
            return;
        }

        for (int i = 0; i < base.length(); i++) {
            dfs(rst, curr + base.charAt(i), base);
        }
    }

    public static void main(String[] args) {
        PhoneNumberPermutation PP = new PhoneNumberPermutation();
        PP.letterCombinations("123");

    }
}
