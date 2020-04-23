public class Ramanujan {
    // goal: create a program that prints true if a given number is a Ramanujan number
    // worst case run time must be n^(1/3)

    public static boolean isRamanujan(long n) {
        long biggestCube = (int) Math.cbrt(n);
        double checkNumRounded = 0;
        double pairNumOne = 0;
        int lowerBound = 0;
        int numPair = 0;
        final double THRESHOLD = .0000000000001;

        boolean found = false;
        // we can check that a cubic pair exists if (n-k^3)^(1/3) is an integer
        for (long k = biggestCube; k > lowerBound; k--) {

            double checkNum = Math.cbrt(n - k * k * k);
            checkNumRounded = Math.rint(checkNum);

            if (Math.abs(checkNum - checkNumRounded) < THRESHOLD) {
                if (pairNumOne == checkNumRounded) {
                    k--;
                    continue;
                }
                pairNumOne = k;
                numPair++;
            }
            if (numPair == 2) return true;

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRamanujan(Long.parseLong(args[0])));

    }
}
