public class TrinomialDP {

    public static long trinomial(int n, int k) {
        long[][] coefficients = new long[n + 1][2 * n + 3];
        coefficients[0][n + 1] = 1;
        for (int row = 1; row <= n; row++) {
            for (int column = 0; column < 2 * n + 2; column++) {
                if (column == 0)
                    coefficients[row][column] = coefficients[row - 1][column] + coefficients[row - 1][column + 1];
                else if (column == 2 * n - 1) {
                    //System.out.println(coefficients[row][column]);
                    coefficients[row][column] = coefficients[row - 1][column] + coefficients[row - 1][column - 1];
                } else
                    coefficients[row][column] = coefficients[row - 1][column] + coefficients[row - 1][column - 1] + coefficients[row - 1][column + 1];
            }

        }
        return coefficients[n][k + n + 1];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(trinomial(n, k));

    }


}
