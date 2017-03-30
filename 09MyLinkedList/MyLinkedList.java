import java.util.*;
public class MyLinkedList{
    int size;
    LNode start;

    public MyLinkedList(){
	size = 0;
	start = null;
    }

    public boolean add(int value){
	start = new LNode(value);
	size++;
	return true;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String list = "[";
	for (int i = size; i >= 0; i--){
	    list = list + " " + get(i) + ",";
	}
	list = list + "]";
	return list;
    }

    public int get(int index){
	LNode current = start;
	for (int i = 0; i = index; i++){
	    current = current.next;
	}
	return current.value;
    }

    public int set(int index, int newValue){
	LNode current = start;
	for (int i = 0; i = index; i++){
	    current = current.next;
	}
	int temp = current.value;
	current.value = newValue;
	return temp;
    }
    
    private class LNode{
	int value;
	LNode next;

	public LNode(int v){
	    value = v;
	}
    }
}
