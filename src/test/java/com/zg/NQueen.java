package com.zg;

public class NQueen {
    private static final int QUEEN_FLAG = 1;

    public static void main(String[] args) {
        int queen = 8;
        int[][] board = new int[queen][queen];
        solveNQueen(board, 0);
    }

    private static void printBoard(int[][] board) {
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt + ", ");
            }
            System.out.println("......");
        }
    }

    private static void solveNQueen(int[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            System.out.println("----------");
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isIllegally(board, row, i)) {
                continue;
            }
            board[row][i] = QUEEN_FLAG;
            solveNQueen(board, row + 1);
            board[row][i] = 0;
        }
    }

    private static boolean isIllegally(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == QUEEN_FLAG) {
                return true;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == QUEEN_FLAG) {
                return true;
            }
        }
        int size = board.length;
        for (int i = row - 1, j = col + 1; i >= 0 && j < size; i--, j++) {
            if (board[i][j] == QUEEN_FLAG) {
                return true;
            }
        }
        return false;
    }
}
