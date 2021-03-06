import java.util.*;
public class MyLinkedList implements Iterable<Integer>{
    private int size = 0;
    private LNode head, tail;
    
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
	if (n < 0 || n >= size){
	    throw new IndexOutOfBoundsException();
	}
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
	if (size == 1){
	    tail = null;
	    head = null;
	}
	else if (target == tail){
	    target.prev.next = null;
	    tail = target.prev;
	}
	else if (target == head){
	    target.next.prev = null;
	    head = target.next;
	}
	else{
	    target.prev.next = target.next;
	    target.next.prev = target.prev;
	}
	size--;
    }
    
    public String toString(){
	LNode current = head;
	String list = "[";
	for (int i = 0; i < size; i++){
	    list += current;
	    if (i != size - 1){
		list = list + ", ";
	    }
	    current = current.next;
	}
	list += "]";
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
	LNode current = head;
	for(int i = 0; i < size; i++){
	    if(current.value == value){
		return i;
	    }
	    current = current.next;
	}
	return -1;
    }
    
    public int remove(int index){
	int L = getNthNode(index).value;
	//System.out.println(size);
	remove(getNthNode(index));
	return L;
    }
    
    public void add(int index, int value){
	LNode TBA = new LNode(value);
	if (size == 0){
	    head = TBA;
	    tail = TBA;
	}
	else if (index == 0){
	    TBA.next = head;
	    head.prev = TBA;
	    head = TBA;
	}
	else{
	    addAfter(getNthNode(index - 1), TBA);
	}
	size++;
    }

    public Iterator<Integer> iterator(){
	return new MyLinkedListIterator(this);
    }

    public class MyLinkedListIterator implements Iterator<Integer>{
	private MyLinkedList Lonk;
	private LNode L;

	public MyLinkedListIterator(MyLinkedList MLL){
	    Lonk = MLL;
	    L = Lonk.head;
	}

	public boolean hasNext(){
	    return L != null;
	}

	public Integer next(){
	    if(hasNext()){
		LNode W = L;
		L = L.next;
		return W.value;
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
