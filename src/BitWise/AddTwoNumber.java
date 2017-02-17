package BitWise;

/**
 * Created by shli15 on 8/1/16.
 */
public class AddTwoNumber {
    public int add(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}
