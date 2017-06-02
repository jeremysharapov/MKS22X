import java.util.*;
public class MyDeque{
    private int front, back, size;
    private String[] data;

    public MyDeque(){
	front = 1;
	back = -1;
	size = 0;
	data = new String[10]; 
    }
    
    public String getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    return data[front];
	}
    }

    public String getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    return data[back];
	}
    }

    private void resize(){
	String[] temp = new String[size * 2];
	for(int b = 0; b <= back; b++){
	    temp[b] = data[b];
	}
	if (front > back){
	    for(int f = 0; f <= data.length - front - 1; f++){
		temp[temp.length - f - 1] = data[data.length - f - 1];
	    }
	}
	front = front + data.length;
	data = temp;
    }
    
    public void addFirst(String s){
	if(s == null){
	    throw new NullPointerException();
	}
	if(size >= data.length){
	    resize();
	}
	front--;
	if(front < 0){
	    front = data.length - 1;
	}
	data[front] = s;
	size++;
	if(size == 1){
	    back = front;
	}
    }

    public void addLast(String s){
	if(s == null){
	    throw new NullPointerException();
	}
	if(size >= data.length){
	    resize();
	}
	back++;
	if(back >= data.length){
	    back = 0;
	}
	data[back] = s;
	size++;
	if(size == 1){
	    front = back;
	}
    }

    public String removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	String ans = data[front];
	data[front] = null;
	front++;
	size--;
	if(front >= data.length){
	    front = 0;
	}
	if(size == 0){
	    front = back;
	}
	return ans;
    }

    public String removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	String ans = data[back];
	data[back] = null;
        back--;
	size--;
	if(back < 0){
	    back = data.length - 1;
	}
	if(size == 0){
	    back = front;
	}
	return ans;
    }
}
