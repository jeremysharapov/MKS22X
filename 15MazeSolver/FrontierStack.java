import java.util.Stack;
public class FrontierStack implements Frontier{
    private Stack<Location> locations;

    public FrontierStack(){
	locations = new Stack<Location>();
    }

    public void add(Location l){
	locations.push(l);
    }
    
    public Location next(){
	return locations.pop();
    }
    
    public boolean hasNext(){
	return locations.size() != 0;
    }
}
