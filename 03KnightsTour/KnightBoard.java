public class KnightBoard{
    private int[][] board;

    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
    }

    public void solve(){
	solveH(0, 0, 1);
    }

    public boolean solveH(int row ,int col, int level){
	if(col >= board.length || row >= board.length || col < 0 || row < 0){
	    return false;
	}
	if(level == board.length * board[0].length){
	    return true;
	}
	if(board[row][col] == 0){
	    board[row][col] = level;
	    return solveH(row + 1, col + 2, level + 1) || 
		solveH(row + 1, col - 2, level + 1) ||
		solveH(row + 2, col + 1, level + 1) ||
		solveH(row + 2, col - 1, level + 1) ||
		solveH(row - 2, col + 1, level + 1) ||
		solveH(row - 2, col - 1, level + 1) ||
		solveH(row - 1, col + 2, level + 1) ||
		solveH(row - 1, col - 2, level + 1);
	}
	return false;
    }
}
