package Search;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by shli15 on 10/10/16.
 */
public class StringPermutation {
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> rst = new ArrayList<String>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(str, rst, temp);
        return rst;
    }

    private void dfs(String str, List<String> rst, List<Integer> temp) {
        if (temp.size() == str.length()) {
            rst.add(serialize(str, temp));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (temp.contains(i)) {
                continue;
            }
            temp.add(i);
            dfs(str, rst, temp);
            temp.remove(temp.size() - 1);
        }
    }

    private String serialize(String str, List<Integer> temp) {
        StringBuilder sb = new StringBuilder();
        for (int t : temp) {
            sb.append(str.charAt(t));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        StringPermutation SP = new StringPermutation();
        List<String> rst = SP.stringPermutation2("abc");
        System.out.print("done");
    }
}
