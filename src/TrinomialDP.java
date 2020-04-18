import java.util.Arrays;

public class TrinomialDP {
    private static long[][] coefficients;

    public static long trinomial(int n, int k) {

        for (int row = 1; row <= n; row++) {
            for (int column = 0; column < 2 * n; column++) {
                if (column == 0)
                    coefficients[row][column] = coefficients[row - 1][column] + coefficients[row - 1][column + 1];
                else if (column == 2 * n - 1) {
                    //System.out.println(coefficients[row][column]);
                    coefficients[row][column] = coefficients[row - 1][column] + coefficients[row - 1][column - 1];
                }
                else
                    coefficients[row][column] = coefficients[row - 1][column] + coefficients[row - 1][column - 1] + coefficients[row - 1][column + 1];
            }

        }
        return coefficients[n][k+n-1];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        coefficients = new long[n + 1][2 * n + 1];
        coefficients[0][n - 1] = 1;
        System.out.println(trinomial(n, k));

        //System.out.println(Arrays.deepToString(coefficients));
    }


}
