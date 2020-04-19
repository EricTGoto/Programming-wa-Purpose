
public class RecursiveSquares {

    // Draws a square centered on (x,y) of the given side length
    // with a light gray background and a black border
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length/2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length/2);

    }

    // Draws a recursive square pattern of order n, centered on (x,y)
    // of given side length
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;
        double yTop = y + length/2;
        double xRight = x + length/2;
        double yBot = y - length/2;
        double xLeft = x - length/2;

        draw(n - 1, xRight, yTop, length / 2);
        draw(n - 1, xLeft, yTop, length / 2);
        drawSquare(x, y, length);
        draw(n- 1, xRight, yBot, length / 2);
        draw(n - 1, xLeft, yBot, length / 2);
        /*
        if (n>1) {
            drawSquare(xLeft, yTop, length / 2);
            drawSquare(xRight, yTop, length / 2);
            drawSquare(xLeft, yBot, length / 2);
            drawSquare(xRight, yBot, length / 2);
        }
        */

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);
    }
}
