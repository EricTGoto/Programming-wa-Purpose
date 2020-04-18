package RecursionAssignment;
//this question involves implementing the reve's puzzle which is an extension of the Hanoi problem, except with 4 poles instead of 3
//we want to move n discs from the 1st pole to the 4th pole while obeying the same rules as the Hanoi problem

public class RevesPuzzle {

    private static void revesPuzzle(int n){

        int k= (int) Math.rint(n+1 - Math.sqrt(2*n+1));

        System.out.println(k);
    }

    public static void main(String[] args) {
        revesPuzzle(5);
        revesPuzzle(7);
    }

    private static void hanoi(int n, boolean left){
        if
    }
}
