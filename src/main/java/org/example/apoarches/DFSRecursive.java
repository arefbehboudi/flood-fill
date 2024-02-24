package org.example.apoarches;

public class DFSRecursive {

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1, 1, 1},
                {1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1}
        };
        int sr = 1, sc = 2, newColor = 2;
        floodFill(image, sr, sc, newColor);
        printImage(image);
    }

    public static void floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            fill(image, sr, sc, oldColor, newColor);
        }
    }

    public static void fill(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor) {
            return;
        }
        image[r][c] = newColor;
        fill(image, r - 1, c, oldColor, newColor);
        fill(image, r + 1, c, oldColor, newColor);
        fill(image, r, c - 1, oldColor, newColor);
        fill(image, r, c + 1, oldColor, newColor);
    }

    public static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

}
