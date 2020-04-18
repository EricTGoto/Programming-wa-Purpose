//this question involves implementing the reve's puzzle which is an extension of the Hanoi problem, except with 4 poles instead of 3
//we want to move n discs from the 1st pole to the 4th pole while obeying the same rules as the Hanoi problem

public class RevesPuzzle {

    private static void revesPuzzle(int n) {
        int k = (int) Math.rint(n + 1 - Math.sqrt(2 * n + 1));
        hanoi(k, "A", "B", "C");
        revesStepThree(n, k, "A", "B", "D");
        hanoi(k, "C", "B", "D");

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        revesPuzzle(n);
    }

    private static void hanoi(int n, String from, String temp, String to) {
        if (n == 0) return;
        hanoi(n - 1, from, to, temp);
        System.out.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, temp, from, to);

    }

    private static void revesStepThree(int n, int TopDisc, String from, String temp, String to) {
        if (n == TopDisc) return;
        revesStepThree(n - 1, TopDisc, from, temp, to);
        System.out.println("Move disc " + n + " from " + from + " to " + to);
        revesStepThree(n - 1, TopDisc, temp, from, to);

    }

}
