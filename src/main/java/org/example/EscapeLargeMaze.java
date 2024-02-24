package org.example;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//OK
public class EscapeLargeMaze {
    private static final int MAX_SIZE = 100;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        for (int[] block : blocked) {
            blockedSet.add(block[0] + "," + block[1]);
        }

        return bfs(blockedSet, source, target) && bfs(blockedSet, target, source);
    }

    private boolean bfs(Set<String> blockedSet, int[] source, int[] target) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(source);
        visited.add(source[0] + "," + source[1]);

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == target[0] && current[1] == target[1]) {
                return true;
            }

            for (int[] dir : directions) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                String key = x + "," + y;

                if (x >= 0 && x < MAX_SIZE && y >= 0 && y < MAX_SIZE &&
                        !blockedSet.contains(key) && !visited.contains(key)) {
                    queue.offer(new int[]{x, y});
                    visited.add(key);
                }
            }

            if (visited.size() == 20000) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] blocked = {{0, 1}, {1, 1}};
        int[] source = {0, 0};
        int[] target = {0, 2};

        EscapeLargeMaze solution = new EscapeLargeMaze();
        boolean canEscape = solution.isEscapePossible(blocked, source, target);
        System.out.println("Can escape: " + canEscape);
    }
}

