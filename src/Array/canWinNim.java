package Array;

/**
 * Created by shli15 on 12/1/16.
 */
public class canWinNim {
    public boolean canWinNim(int n) {
        int[] cache = new int[n + 1];
        for (int i = 1; i < cache.length; i++) cache[i] = -1;
        return canWin(n, true, cache) == 1;
    }

    private int canWin(int n, boolean yourMove, int[] cache) {
        if (n >=0 && cache[n] != -1) return cache[n];
        if (n == 0) return 0;
        if (n <= 3 && yourMove) return 1;
        if (n == 4 && yourMove) return 0;
        yourMove = !yourMove;
        cache[n] = canWin(n - 1, yourMove, cache) | canWin(n - 2, yourMove, cache) | canWin(n - 3, yourMove, cache);
        return cache[n];
    }

    public static void main(String[] args) {
        canWinNim CWN = new canWinNim();
        boolean win = CWN.canWinNim(5);
        System.out.print("done");
    }
}
