// this question involves implementing the reve's puzzle which is an extension of the Hanoi problem, except with 4 poles instead of 3
// we want to move n discs from the 1st pole to the 4th pole while obeying the same rules as the Hanoi problem

public class RevesPuzzle {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        fourPosts(n, "A", "B", "C", "D");
    }

    private static void fourPosts(int n, String from, String temp1, String temp2, String to) {
        int k = 0;

        if (n==1) {
            System.out.println("Move disc " + n + " from " + from + " to " + to);
        }else {
            k = (int) Math.rint(n + 1 - Math.sqrt(2 * n + 1));
            if(n-k==0) return;
            fourPosts(n - k, from, temp2, to, temp1);
            System.out.println("Move disc " + (n-k) + " from " + from + " to " + to);
            //hanoi(k, from, to, temp2);
            fourPosts(n - k, temp1, from, temp2, to);

        }
    }


    private static void hanoi(int n, String from, String to, String temp) {
        if (n != 0) {
            hanoi(n - 1, from, temp, to);
            System.out.println("Move disc " + n + " from " + from + " to " + to);
            hanoi(n - 1, temp, to, from);
        }
    }

}
