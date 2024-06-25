import java.util.Arrays;

public class PyramidSum {

    public static int maximumSum(int[][] pyramid) {
        int n = pyramid.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < pyramid[i].length; j++) {
                pyramid[i][j] += Math.max(pyramid[i + 1][j], pyramid[i + 1][j + 1]);
            }
        }
        return pyramid[0][0];
    }

    public static void main(String[] args) {
        int[][] pyramid = {
                {3},
                {7, 4},
                {4, 6, 8},
                {9, 3, 2, 5}
        };

        int maximumSum = maximumSum(pyramid);
        System.out.println("Максимальная сумма скольжения: " + maximumSum);
    }
}
