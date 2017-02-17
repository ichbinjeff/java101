package String;

/**
 * Created by shli15 on 9/20/16.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int i = 0;
        int pointer = A.length - 1;

        while (i <= pointer) {
            if (A[i] == elem) {
                A[i] = A[pointer];
                pointer--;
            } else {
                i++;
            }
        }

        return pointer + 1;

    }

    public static void main(String[] args) {
        int[] tst = new int[] {0,4,4,0,0,2,4,4};
        RemoveElement RE = new RemoveElement();
        RE.removeElement(tst, 4);
    }
}
