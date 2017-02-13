public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }
    

    public void solve(){
	solveH(0);
    }

    private boolean solveH(int col){
	if(col >= board.length){
	    return true;
	}
	for(int row = 0; row < board.length; row++){
	    if(board[row][col] == 0){
		addQueen(row, col);
		if(solveH(col + 1)){
		    return true;
		}
		else{
		    removeQueen(row, col);
		}
	    }
	}
	return false;
    }

    private void addQueen(int r, int c){
	board[r][c] = -1;
	for(int row = 0; row < board.length; row++){
	    for(int column = 0; column < board.length; column++){
		if((column == c || row == r || (Math.abs(row - r) == Math.abs(column - c))) && board[row][column] != -1){
		    board[row][column]++;
		}
	    }
	}
    }

    private void removeQueen(int r, int c){
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board.length; col++){
		if((col == c || row == r || (Math.abs(row - r) == Math.abs(col - c))) && board[row][col] != -1){
		    board[row][col]--;
		}
	    }
	}
	board[r][c] = 0;
    }
    
    public void countSolutions(){
	countSolutionsH(0);
    }
    
    public void countSolutionsH(int col){
	if(col >= board.length){
	    solutionCount++;
	    return;
	}
	for(int row = 0; row < board.length; row++){
	    if(board[row][col] == 0){
		addQueen(row, col);
		countSolutionsH(col + 1);
		removeQueen(row, col);
	    }
	}
    }
    
    public int getSolutionCount(){
	if(solutionCount > 0){
	    return solutionCount;
	}
	else{
	    return -1;
	}
    }
    
    public String toString(){
    	String ans = "";
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board.length; c++){
		if(board[r][c] == -1){
		    ans += "Q ";
		}
		else{
		    ans += board[r][c] + " ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }
}
