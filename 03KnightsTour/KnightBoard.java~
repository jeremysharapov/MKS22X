public class KnightBoard{
    private int[][] board;

    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
    }

    public void solve(){
	solveH(0, 0, 1);
    }

    public boolean solveH(int row ,int col, int level){
	if(level == board.length * board[0].length){
	    return true;
	}
	if(col >= board[0].length || row >= board.length || col < 0 || row < 0){
	    return false;
	}
	if(board[row][col] == 0){
	    board[row][col] = level;
	    if( solveH(row + 1, col + 2, level + 1) || 
		solveH(row + 1, col - 2, level + 1) ||
		solveH(row + 2, col + 1, level + 1) ||
		solveH(row + 2, col - 1, level + 1) ||
		solveH(row - 2, col + 1, level + 1) ||
		solveH(row - 2, col - 1, level + 1) ||
		solveH(row - 1, col + 2, level + 1) ||
		solveH(row - 1, col - 2, level + 1)){
		return true;
	    }
	    else{
		board[row][col] = 0;
	    }
	}
	return false;
    }

    public String toString(){
	String ans = "";
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board.length; c++){
		if(board[r][c] >= 10){
		    ans += board[r][c] + " ";
		}
		else{
		    ans += " " + board[r][c] + " ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[] args){
	KnightBoard k1 = new KnightBoard(5, 5);
	k1.solve();
	System.out.println(k1);
    }
}
