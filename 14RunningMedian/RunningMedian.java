import java.util.*;
public class RunningMedian{
    private MyHeap lesser;
    private MyHeap greater;

    public RunningMedian(){
	lesser = new MyHeap();
	greater = new MyHeap(false);
    }

    public double getMedian(){
	if (lesser.size() + greater.size() == 0){
	    throw new NoSuchElementException();
	}
	if (greater.size() > lesser.size()){
	    return greater.peek();
	}
	if (greater.size() < lesser.size()){
	    return lesser.peek();
	}
	else{
	    return (lesser.peek() + greater.peek()) / 2.0;
	}
    }

    public void add(int n){
	if (lesser.size() + greater.size() == 0){
	    lesser.add(n);
	}
	else if (n < getMedian()) {
	    lesser.add(n);
	    if (lesser.size() - greater.size() > 1){
		greater.add(lesser.remove());
	    }
	}
	else{
	    greater.add(n);
	    if (greater.size() - lesser.size() > 1) {
		lesser.add(greater.remove());
	    }
	}
    }
}
