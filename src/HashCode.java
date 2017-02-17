/**
 * Created by jli on 4/19/16.
 */
public class HashCode {
    // a b c d
    // a * 33^3 + b * 33^2 + c * 33 + d
    public int hashCode(char[] key,int HASH_SIZE) {
//        int size = key.length - 1;
//        int rst = 0;
//        int index = 0;
//
//        String curr = "";
//        while (size >= 0) {
//            rst += (Math.pow(33, size) * (int)key[index]) % HASH_SIZE;
//            curr += "(" + "33^" + size + "*" + (int)key[index] + ")"  + "%" + HASH_SIZE + "+";
//            size --;
//            index ++;
//        }
//
//        return rst % HASH_SIZE;

        long ans = 0;
        String curr = "";
        for(int i = 0; i < key.length;i++) {
            ans = (ans * 33 + (int)(key[i])) % HASH_SIZE;
            curr += "(" + ans + "*33" + (int)key[i] + ")" + "%" + HASH_SIZE + "+";
            ans %= HASH_SIZE;

        }
        return (int)ans;
    }

    public static void main(String[] args) {
        HashCode hc = new HashCode();
        char[] charArr = "abcd".toCharArray();

        int value = hc.hashCode(charArr, 100);
        System.out.print(value);
    }
}
