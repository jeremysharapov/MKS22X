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
	for(int t = 0; t <= tail; t++){
	    temp[t] = data[t];
	}
	if (head > tail){
	    for(int h = 0; h >= data.length - head - 1; h++){
		temp[temp.length - h - 1] = data[data.length - h - 1];
	    }
	}
    }
    
    public void addFirst(String s){
	if(s == null){
	    throw new NullPointerException();
	}
	if(size == data.length){
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
