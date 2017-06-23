import java.util.*;

public class MyHeap{
    private String[] data;
    private int size;
    private int n;

    public MyHeap(){
	data = new String[10];
	size = 0;
	n = 1;
	//data[0] = 1;
    }

    public MyHeap(boolean max){
	data = new String[10];
	size = 0;
	if (max){
	    n = 1;
	    //data[0] = 1;
	}
	else{
	    n = -1;
	    //data[0] = -1;
	}
    }

    public int size(){
	return size;
    }
    
    private void grow(){
        String[] temp = new String[size * 2];
	for(int i = 0; i <= size; i++){
	    temp[i] = data[i];
	}
	data = temp;
    }
    
    public String peek(){
	if (size != 0){
	    return data[1];
	}
	else{
	    throw new NoSuchElementException();
	}
    }

    public String remove(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String ans = data[1];
	data[1] = data[size];
	data[size] = null;
	size--;
	pushDown();
	//System.out.println(Arrays.toString(data));
	//System.out.println(size);
	return ans;
    }

    public void add(String s){
	if (size + 1 == data.length){
	    grow();
	}
	size++;
	data[size] = s;
	pushUp();
	//System.out.println(Arrays.toString(data));
	//System.out.println(size);
    }

    private void pushUp(){
	for (int i = size; (data[i].compareTo(data[i / 2]) * n) > 0 && i > 1; i = i / 2){
	    String temp = data[i];
	    data[i] = data[i / 2];
	    data[i / 2] = temp;
	    // System.out.println(Arrays.toString(data));
	}
    }

    private void pushDown(){
	int i = 1;
        while((i * 2) <= size){
	    if((i * 2 + 1) <= size &&(data[i * 2 + 1].compareTo(data[i * 2]) * n) > 0){
		if((data[i].compareTo(data[i * 2 + 1]) * n) < 0){
		    String temp = data[i * 2 + 1];
		    data[i * 2 + 1] = data[i];
		    data[i] = temp;
		    i = i * 2 + 1;
		}
		else{
		    return;
		}
	    }
	    else{
		if((data[i].compareTo(data[i * 2]) * n) < 0){
		    String temp = data[i * 2];
		    data[i * 2] = data[i];
		    data[i] = temp;
		    i = i * 2;
		}
		else{
		    return;
		}
	    }
	}
	//System.out.println(Arrays.toString(data));
    }
}
