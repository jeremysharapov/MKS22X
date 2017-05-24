import java.util.LinkedList;
public class FrontierQueue implements Frontier{
    private LinkedList<Location> locations;

    public FrontierQueue(){
	locations = new LinkedList<Location>();
    }

    public void add(Location l){
	locations.add(l);
    }

    public Location next(){
	return locations.remove();
    }
    
    public boolean hasNext(){
	return locations.size() != 0;
    }
}
