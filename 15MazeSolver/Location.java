public class Location implements Comparable<Location>{
    private int row, col;
    private int distToStart, distToGoal;
    private Location previous;
    private boolean aStar;

    public Location(int r, int c, Location prev, int dTS, int dTG, boolean a){
	row = r;
	col = c;
	previous = prev;
	distToStart = dTS;
	distToGoal = dTG;
	aStar = a;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    public int getDistToStart(){
	return distToStart;
    }

    public int getDistToGoal(){
	return distToGoal;
    }

    public boolean getAStar(){
	return aStar;
    }

    public Location getPrev(){
	return previous;
    }

    public int compareTo(Location other){
	if (aStar){
	    return distToGoal + distToStart - (other.getDistToGoal() + other.getDistToStart());
	}
	else{
	    return distToGoal - other.getDistToGoal();
	}
    }
}
