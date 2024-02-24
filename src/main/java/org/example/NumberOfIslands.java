package org.example;

import java.util.Arrays;

//OK
public class NumberOfIslands {

    static int counter = 0;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        counter++;

        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
            return;
        }


        grid[row][col] = '0'; // Mark as visited

        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        NumberOfIslands solution = new NumberOfIslands();
        int numIslands = solution.numIslands(grid);
        System.out.println("Number of islands: " + numIslands);
        System.out.println("Counter: " + counter);
        System.out.println(Arrays.deepToString(grid));
    }
}