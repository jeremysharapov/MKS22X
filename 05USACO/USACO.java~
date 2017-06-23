import java.util.*;
import java.io.*;

public class USACO{
   
    /* public static void Bronze(String filename){
	Scanner scan = new Scanner(new File ("filename"));
	int[] firstLine;
	int count = 0;
	while (scan.nextLine().hasNext()){
	    firstLine[count] = (int)scan.next();
	    count++;
	}
	int[][] grid = new int[firstLine[0]][firstLine[1]];
	int elevation = firstLine[2];
	int steps = firstLine[3];
	for (int row = 0; row < firstLine[0]; row++){
	    for (int col = 0; col < firstLine[1]; col++){
		grid[row][col] = scan.nextInt();
	    }
	}
	/*while (scan.hasNextLine()){
	    stomp(scan.nextInt(), scan.nextInt(), scan.nextInt());
	    }
	    }*/
    
    public static int Silver(String filename){
	try{
	    Scanner scan = new Scanner(new File ("filename"));
	    int[][] grid = new int[scan.nextInt()][scan.nextInt()];
	    int time = scan.nextInt();
	    for (int row = 0; row < grid.length; row++){
		for (int col = 0; col < grid[0].length; col++){
		    if (scan.next() == "*"){
			grid[row][col] = -1;
		    }
		    else{
			grid[row][col] = 0;
		    }
		}
	    }
	    int startx = scan.nextInt() - 1;
	    int starty = scan.nextInt() - 1;
	    int endx = scan.nextInt() - 1;
	    int endy = scan.nextInt() - 1;
	    grid[startx][starty] = 1;
	    return SilverH(grid, grid, time, endx, endy, 1);
	}
	catch(FileNotFoundException FNFE){
	    System.out.println("File not found");
	    System.exit(1);
	}
	return 0;
    }

    public static boolean isValid(int r, int c, int[][] field){
	return r >= 0 && r < field.length && c >= 0 && c < field[0].length && field[r][c] != -1;
    }
    
    public static int SilverH(int[][] now, int[][] next, int t, int x, int y, int step){
	for (int row = 0; row < now.length; row++){
	    for (int col = 0; col < now[0].length; col++){
		if (now[row][col] != -1 && now[row][col] != 0){
		    if (isValid(row + 1, col, next)){
			next[row + 1][col] += now[row][col];
		    }
		    if (isValid(row - 1, col, next)){
			next[row - 1][col] += now[row][col];
		    }
		    if (isValid(row, col + 1, next)){
			next[row][col + 1] += now[row][col];
		    }
		    if (isValid(row, col - 1, next)){
			next[row][col - 1] += now[row][col];
		    }
		    next[row][col] = 0;
		}
	    }
	}
	if (step == t){
	    return next[x][y];
	}
	else{
	    return SilverH(next, next, t, x, y, step + 1);
	}
    }

    public static void main(String[] args){
	System.out.println(Silver("SilverInput"));
    }
}
