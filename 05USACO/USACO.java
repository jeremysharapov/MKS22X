import java.util.*;
import java.io.*;

public class USACO{
   
    public static Bronze(String filename){
	Scanner scan = new Scanner(new File ("filename"));
	int[] firstLine;
	int count = 0;
	while (scan.nextLine().hasNextInt()){
	    firstLine[count] = scan.nextInt();
	}
	int[][] grid = new int[firstLine[0]][firstLine[1]];
	int elevation = firstLine[2];
	int steps = firstLine[3];
	for (int row = 0; row < firstLine[0]; row++){
	    for (int col = 0; col < firstLine[1]; col++){
		grid[row][col] = scan.nextInt();
	    }
	}
	while (scan.hasNextLine()){
	    stomp(scan.nextInt(), scan.nextInt(), scan.nextInt());
	}
    }

    public void stomp
