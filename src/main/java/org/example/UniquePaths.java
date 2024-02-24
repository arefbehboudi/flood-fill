package org.example;

public class UniquePaths {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 0, 1},
                {0, 0, 0}
        };
        int sr = 0, sc = 0, er = 2, ec = 2;
        int uniquePaths = countUniquePaths(grid, sr, sc, er, ec);
        System.out.println("Number of unique paths: " + uniquePaths);
    }

    public static int countUniquePaths(int[][] grid, int sr, int sc, int er, int ec) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        dp[sr][sc] = 1;

        for (int r = sr; r <= er; r++) {

            for (int c = sc; c <= ec; c++) {
                if (grid[r][c] == 1) continue;
                if (r > 0) dp[r][c] += dp[r - 1][c];
                if (c > 0) dp[r][c] += dp[r][c - 1];
            }

        }

        return dp[er][ec];
    }


}
