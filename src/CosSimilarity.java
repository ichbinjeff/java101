/**
 * Created by jli on 10/30/15.
 */
public class CosSimilarity {
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        if (A.length != B.length) {
            return 2;
        }

        double numerator = 0;
        double denominator = 0;
        double operatorA = 0;
        double operatorB = 0;

        for (int i = 0; i < A.length; i++) {
            numerator += A[i] * B[i];
            operatorA += (A[i]) ^ 2;
            operatorB += (B[i]) ^ 2;
        }

        denominator = Math.sqrt(operatorA) + Math.sqrt(operatorB);
        if (denominator == 0) {
            return 2;
        }

        return numerator / denominator;
    }
}
