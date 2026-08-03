class Solution {
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[] boxes = new int[9];

    public boolean isValidSudoku(char[][] board) {
        for(int row = 0;row<9;row++) {
            for(int col = 0;col<9;col++) {
                if(board[row][col] == '.') continue;

                int num = board[row][col] - '0';
                if(isNumPresent(row, col, num)) {
                    return false;
                }
                rows[row] |= (1 << num); // Shift left and do OR to set that num bit
                cols[col] |= (1 << num);
                boxes[getBoxNum(row, col)] |= (1<< num);
            }
        }
        return true;
    }
    private boolean isNumPresent(int row, int col, int num) {
        if(
            ((rows[row] & (1 << num)) != 0) ||
            ((cols[col] & (1 << num)) != 0) ||
            ((boxes[getBoxNum(row, col)] & (1 << num)) != 0)) {
                return true;
            }
        else return false;
    }

    private int getBoxNum(int row, int col) {
        int boxRow = row/3; // Integer division already floors the division
        int boxCol = col/3;
        return (boxRow * 3) + boxCol;
    }

}
