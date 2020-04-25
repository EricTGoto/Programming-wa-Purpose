import java.awt.Color;

public class KernelFilter {
    // a library that allows a user to apply various kernel filters to images

    // Returns a new picture that applies a Gaussian blur filter to the given picture
    public static Picture gaussian(Picture picture) {

        int row = picture.width();
        int column = picture.height();
        int r = 0, g = 0, b = 0;
        Picture filteredPicture = new Picture(row, column);

        double[][] kernel = {
                {1.0 / 16, 1.0 / 8, 1.0 / 16},
                {1.0 / 8, 1.0 / 4, 1.0 / 8},
                {1.0 / 16, 1.0 / 8, 1.0 / 16}
        };
        /*
        int r, r0, r1, r2, r3, r4, r5, r6, r7, r8;
        int g, g0, g1, g2, g3, g4, g5, g6, g7, g8;
        int b, b0, b1, b2, b3, b4, b5, b6, b7, b8;



        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                // upper left pixel
                if (i == 0 && k == 0) {
                    r0 = picture.get(row - 1, column - 1).getRed();
                    g0 = picture.get(row - 1, column - 1).getGreen();
                    b0 = picture.get(row - 1, column - 1).getBlue();
                } else if (i == 0 && k == column - 1) {
                    r0 = picture.get(row - 1, column - 2).getRed();
                    g0 = picture.get(row - 1, column - 2).getGreen();
                    b0 = picture.get(row - 1, column - 2).getBlue();
                } else if (i == row - 1 && k == 0) {
                    r0 = picture.get(row - 1, column - 1).getRed();
                    g0 = picture.get(row - 1, column - 1).getGreen();
                    b0 = picture.get(row - 1, column - 1).getBlue();
                } else if (i == 0) {
                    r0 = picture.get(row - 1, k - 1).getRed();
                    g0 = picture.get(row - 1, k - 1).getGreen();
                    b0 = picture.get(row - 1, k - 1).getBlue();
                } else if (k == 0) {
                    r0 = picture.get(i - 1, column - 1).getRed();
                    g0 = picture.get(i - 1, column - 1).getGreen();
                    b0 = picture.get(i - 1, column - 1).getBlue();
                } else {
                    r0 = picture.get(i - 1, k - 1).getRed();
                    g0 = picture.get(i - 1, k - 1).getGreen();
                    b0 = picture.get(i - 1, k - 1).getBlue();
                }

                // upper center pixel
                if (i == 0) {
                    r1 = picture.get(row - 1, k).getRed();
                    g1 = picture.get(row - 1, k).getGreen();
                    b1 = picture.get(row - 1, k).getBlue();
                } else {
                    r1 = picture.get(i - 1, k).getRed();
                    g1 = picture.get(i - 1, k).getGreen();
                    b1 = picture.get(i - 1, k).getBlue();
                }

                // upper right pixel
                if (i == 0 && k == 0) {
                    r2 = picture.get(row - 1, 1).getRed();
                    g2 = picture.get(row - 1, k + 1).getGreen();
                    b2 = picture.get(row - 1, k + 1).getBlue();
                } else if (i == 0 && k == column - 1) {
                    r2 = picture.get(row - 1, 0).getRed();
                    g2 = picture.get(row - 1, 0).getGreen();
                    b2 = picture.get(row - 1, 0).getBlue();
                } else if (i == row - 1 && k == column - 1) {
                    r2 = picture.get(row - 1, column - 2).getRed();
                    g2 = picture.get(row - 1, column - 2).getGreen();
                    b2 = picture.get(row - 1, column - 2).getBlue();
                } else if (k == column - 1) {
                    r2 = picture.get(row - 1, 0).getRed();
                    g2 = picture.get(row - 1, 0).getGreen();
                    b2 = picture.get(row - 1, 0).getBlue();
                } else {
                    r2 = picture.get(row - 1, k + 1).getRed();
                    g2 = picture.get(row - 1, k + 1).getGreen();
                    b2 = picture.get(row - 1, k + 1).getBlue();
                }

                //center left pixel
                if (i == 0) {
                    r3 = picture.get(i, column - 1).getRed();
                    g3 = picture.get(i, column - 1).getGreen();
                    b3 = picture.get(i, column - 1).getBlue();
                } else {
                    r3 = picture.get(i - 1, k).getRed();
                    g3 = picture.get(i - 1, k).getGreen();
                    b3 = picture.get(i - 1, k).getBlue();
                }

                // center pixel
                r4 = picture.get(i, k).getRed();
                g4 = picture.get(i, k).getGreen();
                b4 = picture.get(i, k).getBlue();

                // center right pixel
                if (k == column - 1) {
                    r5 = picture.get(i, 0).getRed();
                    g5 = picture.get(i, 0).getGreen();
                    b5 = picture.get(i, 0).getBlue();
                } else {
                    r5 = picture.get(i, k + 1).getRed();
                    g5 = picture.get(i, k + 1).getGreen();
                    b5 = picture.get(i, k + 1).getBlue();
                }

                // bottom left pixel
                if (i == 0 && k == 0) {
                    r6 = picture.get(i + 1, column - 1).getRed();
                    g6 = picture.get(i + 1, column - 1).getGreen();
                    b6 = picture.get(i + 1, column - 1).getBlue();
                } else if (i == row - 1 && k == 0) {
                    r6 = picture.get(0, column - 1).getRed();
                    g6 = picture.get(0, column - 1).getGreen();
                    b6 = picture.get(0, column - 1).getBlue();
                } else if (i == row - 1 && k == column - 1) {
                    r6 = picture.get(0, column - 2).getRed();
                    g6 = picture.get(0, column - 2).getGreen();
                    b6 = picture.get(0, column - 2).getBlue();
                } else if (k == 0) {
                    r6 = picture.get(i + 1, column - 1).getRed();
                    g6 = picture.get(i + 1, column - 1).getGreen();
                    b6 = picture.get(i + 1, column - 1).getBlue();
                } else if (i == row - 1) {
                    r6 = picture.get(0, k - 1).getRed();
                    g6 = picture.get(0, k - 1).getGreen();
                    b6 = picture.get(0, k - 1).getBlue();
                } else {
                    r6 = picture.get(i + 1, k - 1).getRed();
                    g6 = picture.get(i + 1, k - 1).getGreen();
                    b6 = picture.get(i + 1, k - 1).getBlue();
                }

                // bottom centre pixel
                if (i == row - 1) {
                    r7 = picture.get(0, k).getRed();
                    g7 = picture.get(0, k).getGreen();
                    b7 = picture.get(0, k).getBlue();
                } else {
                    r7 = picture.get(i + 1, k).getRed();
                    g7 = picture.get(i + 1, k).getGreen();
                    b7 = picture.get(i + 1, k).getBlue();
                }

                // bottom right pixel

                if (i == 0 && k == column - 1) {
                    r8 = picture.get(i + 1, 0).getRed();
                    g8 = picture.get(i + 1, 0).getGreen();
                    b8 = picture.get(i + 1, 0).getBlue();
                } else if (i == row - 1 && k == column - 1) {
                    r8 = picture.get(0, 0).getRed();
                    g8 = picture.get(0, 0).getGreen();
                    b8 = picture.get(0, 0).getBlue();
                } else if (i == row - 1) {
                    r8 = picture.get(0, k + 1).getRed();
                    g8 = picture.get(0, k + 1).getGreen();
                    b8 = picture.get(0, k + 1).getBlue();
                } else if (k == column - 1) {
                    r8 = picture.get(i + 1, 0).getRed();
                    g8 = picture.get(i + 1, 0).getGreen();
                    b8 = picture.get(i + 1, 0).getBlue();
                } else {
                    r8 = picture.get(i + 1, k + 1).getRed();
                    g8 = picture.get(i + 1, k + 1).getGreen();
                    b8 = picture.get(i + 1, k + 1).getBlue();
                }

                r = (int) Math.rint(r0 * kernel[0][0] + r1 * kernel[0][1] + r2 * kernel[0][2] + r3 * kernel[1][0] + r4 * kernel[1][1] +
                        r5 * kernel[1][2] + r6 * kernel[2][0] + r7 * kernel[2][1] + r8 * kernel[2][2]);
                g = (int) Math.rint(g0 * kernel[0][0] + g1 * kernel[0][1] + g2 * kernel[0][2] + g3 * kernel[1][0] + g4 * kernel[1][1] +
                        g5 * kernel[1][2] + g6 * kernel[2][0] + g7 * kernel[2][1] + g8 * kernel[2][2]);
                b = (int) Math.rint(b0 * kernel[0][0] + b1 * kernel[0][1] + b2 * kernel[0][2] + b3 * kernel[1][0] + b4 * kernel[1][1] +
                        b5 * kernel[1][2] + b6 * kernel[2][0] + b7 * kernel[2][1] + b8 * kernel[2][2]);

                if (r > 255) r = 255;
                if (g > 255) g = 255;
                if (b > 255) b = 255;



                Color pixel = new Color(r, g, b);
                filteredPicture.set(i, k, pixel);
            }
        }
         */
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                int[][] colors = getColors(picture, row, column, i, k);
                r = kernelRed(kernel, colors);
                g = kernelGreen(kernel, colors);
                b = kernelBlue(kernel, colors);
                Color pixel = new Color(r, g, b);
                filteredPicture.set(i, k, pixel);
            }
        }

        return filteredPicture;
    }

    public static Picture sharpen(Picture picture) {
        return null;
    }

    private static int[][] getColors(Picture picture, int row, int column, int rowIndex, int columnIndex) {

        int r0 = 0, r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0, r6 = 0, r7 = 0, r8 = 0;
        int g0 = 0, g1 = 0, g2 = 0, g3 = 0, g4 = 0, g5 = 0, g6 = 0, g7 = 0, g8 = 0;
        int b0 = 0, b1 = 0, b2 = 0, b3 = 0, b4 = 0, b5 = 0, b6 = 0, b7 = 0, b8 = 0;

        if (rowIndex == 0 && columnIndex == 0) {
            r0 = picture.get(row - 1, column - 1).getRed();
            g0 = picture.get(row - 1, column - 1).getGreen();
            b0 = picture.get(row - 1, column - 1).getBlue();
        } else if (rowIndex == 0 && columnIndex == column - 1) {
            r0 = picture.get(row - 1, column - 2).getRed();
            g0 = picture.get(row - 1, column - 2).getGreen();
            b0 = picture.get(row - 1, column - 2).getBlue();
        } else if (rowIndex == row - 1 && columnIndex == 0) {
            r0 = picture.get(row - 1, column - 1).getRed();
            g0 = picture.get(row - 1, column - 1).getGreen();
            b0 = picture.get(row - 1, column - 1).getBlue();
        } else if (rowIndex == 0) {
            r0 = picture.get(row - 1, columnIndex - 1).getRed();
            g0 = picture.get(row - 1, columnIndex - 1).getGreen();
            b0 = picture.get(row - 1, columnIndex - 1).getBlue();
        } else if (columnIndex == 0) {
            r0 = picture.get(rowIndex - 1, column - 1).getRed();
            g0 = picture.get(rowIndex - 1, column - 1).getGreen();
            b0 = picture.get(rowIndex - 1, column - 1).getBlue();
        } else {
            r0 = picture.get(rowIndex - 1, columnIndex - 1).getRed();
            g0 = picture.get(rowIndex - 1, columnIndex - 1).getGreen();
            b0 = picture.get(rowIndex - 1, columnIndex - 1).getBlue();
        }

        // upper center pixel
        if (rowIndex == 0) {
            r1 = picture.get(row - 1, columnIndex).getRed();
            g1 = picture.get(row - 1, columnIndex).getGreen();
            b1 = picture.get(row - 1, columnIndex).getBlue();
        } else {
            r1 = picture.get(rowIndex - 1, columnIndex).getRed();
            g1 = picture.get(rowIndex - 1, columnIndex).getGreen();
            b1 = picture.get(rowIndex - 1, columnIndex).getBlue();
        }

        // upper right pixel
        if (rowIndex == 0 && columnIndex == 0) {
            r2 = picture.get(row - 1, 1).getRed();
            g2 = picture.get(row - 1, columnIndex + 1).getGreen();
            b2 = picture.get(row - 1, columnIndex + 1).getBlue();
        } else if (rowIndex == 0 && columnIndex == column - 1) {
            r2 = picture.get(row - 1, 0).getRed();
            g2 = picture.get(row - 1, 0).getGreen();
            b2 = picture.get(row - 1, 0).getBlue();
        } else if (rowIndex == row - 1 && columnIndex == column - 1) {
            r2 = picture.get(row - 1, column - 2).getRed();
            g2 = picture.get(row - 1, column - 2).getGreen();
            b2 = picture.get(row - 1, column - 2).getBlue();
        } else if (columnIndex == column - 1) {
            r2 = picture.get(row - 1, 0).getRed();
            g2 = picture.get(row - 1, 0).getGreen();
            b2 = picture.get(row - 1, 0).getBlue();
        } else {
            r2 = picture.get(row - 1, columnIndex + 1).getRed();
            g2 = picture.get(row - 1, columnIndex + 1).getGreen();
            b2 = picture.get(row - 1, columnIndex + 1).getBlue();
        }

        //center left pixel
        if (rowIndex == 0) {
            r3 = picture.get(rowIndex, column - 1).getRed();
            g3 = picture.get(rowIndex, column - 1).getGreen();
            b3 = picture.get(rowIndex, column - 1).getBlue();
        } else {
            r3 = picture.get(rowIndex - 1, columnIndex).getRed();
            g3 = picture.get(rowIndex - 1, columnIndex).getGreen();
            b3 = picture.get(rowIndex - 1, columnIndex).getBlue();
        }

        // center pixel
        r4 = picture.get(rowIndex, columnIndex).getRed();
        g4 = picture.get(rowIndex, columnIndex).getGreen();
        b4 = picture.get(rowIndex, columnIndex).getBlue();

        // center right pixel
        if (columnIndex == column - 1) {
            r5 = picture.get(rowIndex, 0).getRed();
            g5 = picture.get(rowIndex, 0).getGreen();
            b5 = picture.get(rowIndex, 0).getBlue();
        } else {
            r5 = picture.get(rowIndex, columnIndex + 1).getRed();
            g5 = picture.get(rowIndex, columnIndex + 1).getGreen();
            b5 = picture.get(rowIndex, columnIndex + 1).getBlue();
        }

        // bottom left pixel
        if (rowIndex == 0 && columnIndex == 0) {
            r6 = picture.get(rowIndex + 1, column - 1).getRed();
            g6 = picture.get(rowIndex + 1, column - 1).getGreen();
            b6 = picture.get(rowIndex + 1, column - 1).getBlue();
        } else if (rowIndex == row - 1 && columnIndex == 0) {
            r6 = picture.get(0, column - 1).getRed();
            g6 = picture.get(0, column - 1).getGreen();
            b6 = picture.get(0, column - 1).getBlue();
        } else if (rowIndex == row - 1 && columnIndex == column - 1) {
            r6 = picture.get(0, column - 2).getRed();
            g6 = picture.get(0, column - 2).getGreen();
            b6 = picture.get(0, column - 2).getBlue();
        } else if (columnIndex == 0) {
            r6 = picture.get(rowIndex + 1, column - 1).getRed();
            g6 = picture.get(rowIndex + 1, column - 1).getGreen();
            b6 = picture.get(rowIndex + 1, column - 1).getBlue();
        } else if (rowIndex == row - 1) {
            r6 = picture.get(0, columnIndex - 1).getRed();
            g6 = picture.get(0, columnIndex - 1).getGreen();
            b6 = picture.get(0, columnIndex - 1).getBlue();
        } else {
            r6 = picture.get(rowIndex + 1, columnIndex - 1).getRed();
            g6 = picture.get(rowIndex + 1, columnIndex - 1).getGreen();
            b6 = picture.get(rowIndex + 1, columnIndex - 1).getBlue();
        }

        // bottom centre pixel
        if (rowIndex == row - 1) {
            r7 = picture.get(0, columnIndex).getRed();
            g7 = picture.get(0, columnIndex).getGreen();
            b7 = picture.get(0, columnIndex).getBlue();
        } else {
            r7 = picture.get(rowIndex + 1, columnIndex).getRed();
            g7 = picture.get(rowIndex + 1, columnIndex).getGreen();
            b7 = picture.get(rowIndex + 1, columnIndex).getBlue();
        }

        // bottom right pixel

        if (rowIndex == 0 && columnIndex == column - 1) {
            r8 = picture.get(rowIndex + 1, 0).getRed();
            g8 = picture.get(rowIndex + 1, 0).getGreen();
            b8 = picture.get(rowIndex + 1, 0).getBlue();
        } else if (rowIndex == row - 1 && columnIndex == column - 1) {
            r8 = picture.get(0, 0).getRed();
            g8 = picture.get(0, 0).getGreen();
            b8 = picture.get(0, 0).getBlue();
        } else if (rowIndex == row - 1) {
            r8 = picture.get(0, columnIndex + 1).getRed();
            g8 = picture.get(0, columnIndex + 1).getGreen();
            b8 = picture.get(0, columnIndex + 1).getBlue();
        } else if (columnIndex == column - 1) {
            r8 = picture.get(rowIndex + 1, 0).getRed();
            g8 = picture.get(rowIndex + 1, 0).getGreen();
            b8 = picture.get(rowIndex + 1, 0).getBlue();
        } else {
            r8 = picture.get(rowIndex + 1, columnIndex + 1).getRed();
            g8 = picture.get(rowIndex + 1, columnIndex + 1).getGreen();
            b8 = picture.get(rowIndex + 1, columnIndex + 1).getBlue();
        }

        int[][] colors = {
                {r0, r1, r2, r3, r4, r5, r6, r7, r8},
                {g0, g1, g2, g3, g4, g5, g6, g7, g8},
                {b0, b1, b2, b3, b4, b5, b6, b7, b8},
        };
        return colors;

    }

    private static int kernelRed(double[][] kernel, int[][] colors) {
        int r = (int) Math.rint(colors[0][0] * kernel[0][0] + colors[0][1] * kernel[0][1] + colors[0][2] * kernel[0][2] +
                colors[0][3] * kernel[1][0] + colors[0][4] * kernel[1][1] +
                colors[0][5] * kernel[1][2] + colors[0][6] * kernel[2][0] +
                colors[0][7] * kernel[2][1] + colors[0][8] * kernel[2][2]);
        if (r > 255) r = 255;
        return r;
    }

    private static int kernelGreen(double[][] kernel, int[][] colors) {
        int g = (int) Math.rint(colors[1][0] * kernel[0][0] + colors[1][1] * kernel[0][1] + colors[1][2] * kernel[0][2] +
                colors[1][3] * kernel[1][0] + colors[1][4] * kernel[1][1] +
                colors[1][5] * kernel[1][2] + colors[1][6] * kernel[2][0] +
                colors[1][7] * kernel[2][1] + colors[1][8] * kernel[2][2]);

        if (g > 255) g = 255;
        return g;

    }

    private static int kernelBlue(double[][] kernel, int[][] colors) {
        int b = (int) Math.rint(colors[2][0] * kernel[0][0] + colors[2][1] * kernel[0][1] + colors[2][2] * kernel[0][2] +
                colors[2][3] * kernel[1][0] + colors[2][4] * kernel[1][1] +
                colors[2][5] * kernel[1][2] + colors[2][6] * kernel[2][0] +
                colors[2][7] * kernel[2][1] + colors[2][8] * kernel[2][2]);
        if (b > 255) b = 255;
        return b;
    }

    public static void main(String[] args) {
        Picture picture = new Picture("baboon.png");
        Picture gaussianPicture = gaussian(picture);
        gaussianPicture.show();
    }
}

