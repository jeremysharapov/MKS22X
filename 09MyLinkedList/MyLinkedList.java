import java.util.*;
public class MyLinkedList implements Iterable<Integer>{
    int size;
    LNode head, tail;
    
    private class LNode{
	LNode next, prev;
	int value;
	public LNode(int value){
	    this.value = value;
	}
	public String toString(){
	    return value + "";
	}
    }
    
    
    public MyLinkedList(){
    }

        
    public int size(){
	return size;
    }

    private LNode getNthNode(int n){
	LNode current = head;
	for (int i = 0; i < n; i++){
	    current = current.next;
	}
	return current;
    }

    private void addAfter(LNode location, LNode toBeAdded){
	if (tail == location){
	    toBeAdded.prev = location;
	    location.next = toBeAdded;
	    tail = toBeAdded;
	}
	else{
	    toBeAdded.next = location.next;
	    toBeAdded.prev = location;
	    location.next.prev = toBeAdded;
	    location.next = toBeAdded;
	}
    }

    private void remove(LNode target){
	if (target == head && target == tail){
	    tail = null;
	    head = null;
	}
	if (target == tail){
	    target.prev.next = null;
	    tail = target.prev;
	}
	if (target == head){
	    target.next.prev = null;
	    head = target.next;
	}
	else{
	    target.prev.next = target.next;
	    target.next.prev = target.prev;
	}
    }
    
    public String toString(){
	LNode current = head;
	String list = "[";
	for (int i = 0; i < size; i++){
	    list = list + " " + current.value;
	    if (i != size - 1){
		list = list + ",";
	    }
	    current = current.next;
	}
	list = list + "]";
	return list;
    }

    public boolean add(int value){
	add(size, value);
	return true;
    }

    public int get(int index){
	return getNthNode(index).value;
    }

    public int set(int index, int value){
	LNode target = getNthNode(index);
	int ans = target.value;
	target.value = value;
	return ans;
    }
    
    public int indexOf(int value){
    }
    
    public int remove(int index){
	remove(getNthNode(index));
    }
    
    public void add(int index, int value){
    }

    public Interator<Integer>{
	return new LinkedListIterator(this);
    }

    public class LinkedListIterator implements Iterator<Integer>{
	private myLinkedList Lonk;
	private LNode L;

	public LinkedListIterator(myLinkedList MLL){
	    Lonk = MLL;
	    L = Lonk.head;
	}

	public boolean hasNext(){
	    return !(L.next == null);
	}

	public Integer next(){
	    if(hasNext()){
		L = L.next;
		return L;
	    }
	    else{
		throw new NoSuchElementException();
	    }
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
}
