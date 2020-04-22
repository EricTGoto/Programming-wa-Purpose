public class Ramanujan {
    // goal: create a program that prints true if a given number is a Ramanujan number
    // worst case run time must be n^(1/3)

    public static boolean isRamanujan(long n) {
        int biggestCube = (int) Math.cbrt(n);
        int smallCube = 0;
        int lowerBound = 0;

        for (int i = 1; i < biggestCube; i++) {
            if (Math.pow(i, 3) + Math.pow(biggestCube, 3) == n) {
                smallCube = i;
            }
        }
        if (smallCube == 0) return false;

        lowerBound = (int) Math.ceil(Math.cbrt(Math.pow(biggestCube, 3) - Math.pow(biggestCube - 1, 3)));

        for (int k = biggestCube - 1; k > lowerBound; k--) {

            double checkNum = Math.cbrt(n - Math.pow(k, 3));
            double checkNumRounded = Math.rint(checkNum);

            if ((checkNum - checkNumRounded) == 0) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRamanujan(Long.parseLong(args[0])));
    }
}
