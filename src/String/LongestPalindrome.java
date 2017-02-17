package String;

/**
 * Created by shli15 on 12/3/16.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] base = new int[256];
        for (int i = 0; i < s.length(); i++) {
            base[s.charAt(i)] ++;
        }
        int maxOdd = 0;
        int even = 0;
        for (int i = 0; i < base.length; i++) {
            if (base[i] > 0 && base[i] % 2 == 0) {
                even += base[i];
            } else if (base[i] % 2 != 0) {
                maxOdd = Math.max(maxOdd, base[i]);
            }
        }
        return maxOdd + even;
    }

    public static void main(String[] args) {
        String tst = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        LongestPalindrome LP = new LongestPalindrome();
        LP.longestPalindrome(tst);
    }
}
