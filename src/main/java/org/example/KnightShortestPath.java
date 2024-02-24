package org.example;

import java.util.LinkedList;
import java.util.Queue;

//OK
public class KnightShortestPath {

    public int shortestPath(int[] start, int[] end) {
        int[][] directions = {
                {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
                {-2, 1}, {-1, 2}, {1, 2}, {2, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int cx = current[0];
                int cy = current[1];

                if (cx == end[0] && cy == end[1]) {
                    return moves;
                }

                for (int[] dir : directions) {
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];

                    if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] start = {0, 0};
        int[] end = {7, 7};

        KnightShortestPath solution = new KnightShortestPath();
        int shortestPath = solution.shortestPath(start, end);
        System.out.println("Shortest path: " + shortestPath);
    }
}
