public class Ramanujan {
    // goal: create a program that prints true if a given number is a Ramanujan number
    // worst case run time must be n^(1/3)

    public static boolean isRamanujan(long n) {
        int biggestCube = (int) Math.cbrt(n);
        int lowerBound = 0;
        double checkNumRounded=0;

        for (int k = biggestCube - 1; k > lowerBound; k--) {

            double checkNum = Math.cbrt(n - Math.pow(k, 3));
            checkNumRounded = Math.rint(checkNum);

            if ((checkNum - checkNumRounded) == 0) {
                biggestCube=--k;
                break;
            }
        }

        for (int k=biggestCube;k>lowerBound;k--){

            double checkNum=Math.cbrt(n-Math.pow(k,3));
            double checkNumRounded2=Math.rint(checkNum);
            if (checkNumRounded2==checkNumRounded) continue;

            if (checkNum-checkNumRounded2==0) return true;

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRamanujan(Long.parseLong(args[0])));
    }
}
