import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private boolean animate;
    private int Sx;
    private int Sy;
    
    
    public Maze(String filename){
	setAnimate(false);
	try{
	    Scanner scan = new Scanner(new File(filename));
	    int row = 1;
	    int col = scan.nextLine().length();
	    String temp = "";
	    while (scan.hasNextLine()){	
		temp = temp + scan.nextLine() + "\n";
		row++;
	    }
	    maze = new char[row][col];
	    Scanner scan2 = new Scanner(new File(filename));
	    int r = 0;
	    while (scan2.hasNextLine()){
		String tempLine = scan2.nextLine();
		for (int c = 0; c < col; c++){
		    maze[r][c] = tempLine.charAt(c);
		}
		r++;
	    }
	    if (!(existanceOfE()) || !(existanceOfS())){
		System.out.println("File is not a valid maze!");
		System.exit(1);
	    }
	}
	catch(FileNotFoundException FNFE){
	    System.out.println("File not found");
	    System.exit(1);
	}
    }

    public boolean existanceOfS(){
	int countS = 0;
	for (int r = 0; r < maze.length; r++){
	    for (int c = 0; c < maze[0].length; c++){
		if (maze[r][c] == 'S'){
		    Sx = c;
		    Sy = r;
		    countS++;
		}
	    }
	}
	return countS == 1;
    }

    public boolean existanceOfE(){
	int countE = 0;
	for (int r = 0; r < maze.length; r++){
	    for (int c = 0; c < maze[0].length; c++){
		if (maze[r][c] == 'E'){
		    countE++;
		}
	    }
	}
	return countE == 1;
    }

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){
        animate = b;
    }


    public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    }

    public boolean solve(){
	int startr = Sy;
	int startc = Sx; 
	maze[startr][startc] = ' ';
	return solve(startr, startc);
    }

    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length){
	    return false;
	}
	if (maze[row][col] == 'E'){
	    return true;
	}
	if(maze[row][col] == '#' || maze[row][col] == '.'){
	    return false;
	}
	if (maze[row][col] == ' '){
	    maze[row][col] = '@';
	    if (solve(row + 1, col) || solve(row, col + 1) || solve(row - 1, col) || solve(row, col - 1)){
		return true;
	    }
	    else{
		maze[row][col] = '.';
	    }
	}
        return false;
    }

    public String toString(){
	String ans = "";
	for (int r = 0; r < maze.length; r++){
	    for (int c = 0; c < maze[0].length; c++){
		ans += maze[r][c];
	    }
	    ans += "\n";
	}
	return ans;
    }
    
    public static void main(String[] args){
	Maze maze1 = new Maze("data3.dat");
	System.out.println(maze1);
	maze1.solve();
	System.out.println(maze1);
    }
}
