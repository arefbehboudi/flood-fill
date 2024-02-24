package org.example.apoarches;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            if (r >= 0 && r < rows && c >= 0 && c < cols && image[r][c] == oldColor) {
                image[r][c] = newColor;
                queue.offer(new int[]{r - 1, c});
                queue.offer(new int[]{r + 1, c});
                queue.offer(new int[]{r, c - 1});
                queue.offer(new int[]{r, c + 1});
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
