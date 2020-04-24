public class MaximumSquareSubmatrix {
    // Given an n-n matrix of 0s and 1s, find a contiguous square submatrix of maximum size that contains only 1s
    // contiguous as in row and column indices must be continuous
    // assume that the array is a square matrix only containing 0s and 1s

    public static int size(int[][] a) {
        int[][] b = new int[a.length + 1][a.length + 1];
        int max = 0;
        for (int i = 1; i < b.length; i++)
            for (int k = 1; k < b.length; k++) {
                if (a[i - 1][k - 1] == 0) {
                    b[i][k] = 0;
                } else {
                    b[i][k] = Math.min(b[i][k - 1], Math.min(b[i - 1][k - 1], b[i - 1][k])) + 1;
                    if (b[i][k] > max) max = b[i][k];
                }
            }
        return max;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(StdIn.readLine());
        int[][] array = new int[n][n];
        int row = 0;
        while (StdIn.hasNextLine()) {

            for (int k = 0; k < n; k++) {
                array[row][k] = StdIn.readInt();
            }
            row++;
        }
        System.out.println(size(array));
    }


}


