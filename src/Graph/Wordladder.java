package Graph;
import java.util.*;

/**
 * Created by shli15 on 9/10/16.
 */
public class Wordladder {
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        Set<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        int len = 1;

        hash.add(start);
        hash.add(end);

        if (start == end) {
            return len;
        }

        queue.offer(start);
        while (!queue.isEmpty()) {
            len ++;
            for (int i = 0; i < queue.size(); i++) {
                String node = queue.poll();
                for (String nextWord : getAdjWords(node, dict)) {
                    if (nextWord.equals(end)) {
                        return len;
                    }

                    if (hash.contains(nextWord)) {
                        continue;
                    }

                    queue.offer(nextWord);
                    hash.add(nextWord);
                }
            }
        }

        return len;
    }

    public List<String> getAdjWords(String word, Set<String> dict) {
        List<String> rst = new ArrayList<String>();
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < wordArr.length; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                String mutatedWord = replace(word, i, j);
                if (dict.contains(mutatedWord)) {
                    rst.add(mutatedWord);
                }
            }
        }

        return rst;
    }

    public String replace(String word, int index, char letter) {
        char[] charArr = word.toCharArray();
        charArr[index] = letter;
        return new String(charArr);
    }

    public static void main(String[] args) {
        Wordladder WL = new Wordladder();
        String start = "hit";
        String end = "cog";
        Set<String> hash = new HashSet<String>();
        hash.add("hot");
        hash.add("dot");
        hash.add("dog");
        hash.add("lot");
        hash.add("log");


        int len = WL.ladderLength(start, end, hash);
        System.out.print(len);
    }

}




