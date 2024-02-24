package org.example.apoarches;

import java.util.Stack;

public class DFSStack {

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
        int rows = image.length;
        int cols = image[0].length;

        int oldColor = image[sr][sc];

        if (oldColor == newColor) return;

        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{sr, sc});

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();

            int r = curr[0];
            int c = curr[1];

            if (r >= 0 && r < rows && c >= 0 && c < cols && image[r][c] == oldColor) {
                image[r][c] = newColor;
                stack.push(new int[]{r - 1, c});
                stack.push(new int[]{r + 1, c});
                stack.push(new int[]{r, c - 1});
                stack.push(new int[]{r, c + 1});
            }
        }
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
