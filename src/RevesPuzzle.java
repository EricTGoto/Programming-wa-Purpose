//this question involves implementing the reve's puzzle which is an extension of the Hanoi problem, except with 4 poles instead of 3
//we want to move n discs from the 1st pole to the 4th pole while obeying the same rules as the Hanoi problem

public class RevesPuzzle {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = (int) Math.rint(n + 1 - Math.sqrt(2 * n + 1));

        revesStepTwo(k, "A", "B", "C", "D");
        revesStepThree(n, k, "A", "C", "D");
        revesStepTwo(k, "B", "D", "C", "A");
    }

    private static void revesStepTwo(int k, String from, String to, String temp1, String temp2) {

        if (k == 0) {
            return;
        }

        if (k == 1) {
            System.out.println("Move disc " + k + " from " + from + " to " + to);
            return;
        }

        revesStepTwo(k - 1, from, temp1, temp2, to);
        revesStepTwo(k - 2, from, temp1, temp2, to);
        System.out.println("Move disc " + k + " from " + from + " to " + to);
        revesStepTwo(k - 2, temp1, to, temp2, from);
        revesStepTwo(k - 1, temp1, to, temp2, from);

    }

    private static void revesStepThree(int n, int topDisc, String from, String temp, String to) {
        if (n == topDisc) return;
        revesStepThree(n - 1, topDisc, from, to, temp);
        System.out.println("Move disc " + n + " from " + from + " to " + to);
        revesStepThree(n - 1, topDisc, temp, from, to);

    }

}
