import java.util.*;

public class MyHeap{
    private int[] data;
    private int size;
    private int n;

    public MyHeap(){
	data = new int[10];
	size = 0;
	n = 1;
    }

    public MyHeap(boolean max){
	data = new int[10];
	size = 0;
	if (max){
	    n = 1;
	}
	else{
	    n = -1;
	}
    }

    public int size(){
	return size;
    }
    
    private void grow(){
        int[] temp = new int[size * 2];
	for(int i = 1; i <= size; i++){
	    temp[i] = data[i];
	}
	data = temp;
    }
    
    public int peek(){
	if (size != 0){
	    return data[1];
	}
	else{
	    throw new NoSuchElementException();
	}
    }

    public int remove(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	int ans = data[size];
	data[1] = data[size];
	data[size] = 0;
	size--;
	pushDown();
	return ans;
    }

    public void add(int s){
	if (size + 1 == data.length){
	    grow();
	}
	size++;
	data[size] = s;
	pushUp();
    }

    private void pushUp(){
	for (int i = size; data[i] > (data[i / 2] * n) && i > 1; i = i / 2){
	    int temp = data[i];
	    data[i] = data[i / 2];
	    data[i / 2] = temp;
	}
    }

    private void pushDown(){
	int i = 1;
	while (i != size && data[i] < (data[i * 2] * n) || data[i] < (data[i * 2 + 1] * n)){
	    if(data[i] < (data[i * 2] * n)){
		int temp = data[i];
		data[i] = data[i * 2];
		data[i * 2] = temp;
		i = i * 2;
	    }
	    else{
		int temp = data[i];
		data[i] = data[i * 2 + 1];
		data[i * 2 + 1] = temp;
		i = i * 2 + 1;
	    }
	}
    }
}
