import java.util.*;
public class MyLinkedList{
    int size;
    LNode start;

    public MyLinkedList(){
	size = 0;
	head = null;
	tail = null;
    }

    public boolean add(int value){
	start = new LNode(value);
	size++;
	return true;
    }

    public void add(int index, int value){
    }

    private void insertAfter(LNode TBA, LNode location){
	if (tail == location){
	    TBA.prev = location;
	    location.next = TBA;
	    tail = TBA;
	}
	else{
	    TBA.next = location.next;
	    TBA.prev = location;
	    location.next.prev = TBA;
	    location.next = TBA;
	}
    }

    private void insertBefore(LNode TBA, LNode location){
	if (head == location){
	    TBA.next = location;
	    location.prev = TBA;
	    head = TBA;
	}
	else{
	    TBA.prev = location.prev;
	    TBA.next = location;
	    location.prev.next = TBA;
	    location.prev = TBA;
	}
    }
    
    public int remove(int index){
	remove(getLNode(index));
    }

    private void remove(LNode x){
	if (x == head && x == tail){
	    tail = null;
	    head = null;
	}
	if (x == tail){
	    x.prev.next = null;
	    tail = x.prev;
	}
	if (x == head){
	    x.next.prev = null;
	    head = x.next;
	}
	else{
	    x.prev.next = x.next;
	    x.next.prev = x.prev;
	}
	return x.value;
    }	
    
    public int size(){
	return size;
    }

    public String toString(){
	LNode current = head;
	String list = "[";
	for (int i = 0; i < size; i++){
	    list = list + " " + current.value + ",";
	    current = current.next;
	}
	list = list + "]";
	return list;
    }

    public int get(int index){
	LNode current = head;
	for (int i = 0; i = index; i++){
	    current = current.next;
	}
	return current.value;
    }

    private LNode getLNode(int index){
	LNode current = head;
	for (int i = 0; i = index; i++){
	    current = current.next;
	}
	return current;
    }
    
    public int set(int index, int newValue){
	LNode current = head;
	for (int i = 0; i = index; i++){
	    current = current.next;
	}
	int temp = current.value;
	current.value = newValue;
	return temp;
    }
    
    private class LNode{
	int value;
	LNode prev;
	LNode next;

	public LNode(int v){
	    value = v;
	}
    }
}
