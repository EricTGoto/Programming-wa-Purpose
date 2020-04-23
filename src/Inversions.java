public class Inversions {

    public static long count(int[] a) {
        long inversions = 0;
        for (int i = 0; i < a.length; i++) {
            for (int k = 1; k < a.length; k++) {
                if (a[i] > a[k] && i < k) inversions++;
            }
        }
        return inversions;
    }

    public static int[] generate(int n, long k) {
        int[] array = new int[n];
        int length = array.length;
        int num = 0;
        n--;

        for (int i = 0; i < array.length; i++) {
            // (k - (n - i) > 0 && (n - i) > 0 && (k-(length-(i+1)))>=0)
            if ((k - (length - (i + 1))) >= 0) {
                array[i] = n;
                k = k - (length - (i + 1));
                n--;
            } else {
                array[i] = num;
                num++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] genArray = generate(n, k);
        for (int i = 0; i < genArray.length; i++)
            System.out.print(genArray[i] + " ");
    }

}
