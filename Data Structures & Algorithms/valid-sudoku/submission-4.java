class Solution {
    /*
    Idea: Represent array lists for rows, columns and boxes in a grid. Each element in a row/col/box array represrnt a binary number, representing a number is set in that particular col/row/box or not
    */
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[] boxes = new int[9];

    public boolean isValidSudoku(char[][] board) {
        for(int row = 0;row<9;row++) {
            for(int col = 0;col<9;col++) {
                if(board[row][col] == '.') continue;

                int num = board[row][col] - '0';
                int bit = (1 << num);
                if(isNumPresent(row, col, num, bit)) {
                    return false;
                }
                rows[row] |= bit; // Shift left and do OR to set that num bit
                cols[col] |= bit;
                boxes[getBoxNum(row, col)] |= bit;
            }
        }
        return true;
    }
    private boolean isNumPresent(int row, int col, int num, int bit){
     return(
            ((rows[row] & bit) != 0) ||
            ((cols[col] & bit) != 0) ||
            ((boxes[getBoxNum(row, col)] & bit) != 0));
    }

    private int getBoxNum(int row, int col) {
        int boxRow = row/3; // Integer division already floors the division
        int boxCol = col/3;
        return (boxRow * 3) + boxCol;
    }

}
