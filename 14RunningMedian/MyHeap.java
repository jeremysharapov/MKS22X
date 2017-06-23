import java.util.*;

public class MyHeap{
    private int[] data;
    private int size;
    private int n;

    public MyHeap(){
	data = new int[10];
	size = 0;
	n = 1;
	data[0] = 1;
    }

    public MyHeap(boolean max){
	data = new int[10];
	size = 0;
	if (max){
	    n = 1;
	    data[0] = 1;
	}
	else{
	    n = -1;
	    data[0] = -1;
	}
    }

    public int size(){
	return size;
    }
    
    private void grow(){
        int[] temp = new int[size * 2];
	for(int i = 0; i <= size; i++){
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
	int ans = data[1];
	data[1] = data[size];
	data[size] = 0;
	size--;
	pushDown();
	//System.out.println(Arrays.toString(data));
	//System.out.println(size);
	return ans;
    }

    public void add(int s){
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
	for (int i = size; (data[i] * n) > (data[i / 2] * n) && i > 1; i = i / 2){
	    int temp = data[i];
	    data[i] = data[i / 2];
	    data[i / 2] = temp;
	    // System.out.println(Arrays.toString(data));
	}
    }

    private void pushDown(){
	int i = 1;
        while((i * 2) <= size){
	    if((i * 2 + 1) <= size &&(data[i * 2 + 1] * n) > (data[i * 2] * n)){
		if(data[i] * n < data[i * 2 + 1] * n){
		    int temp = data[i * 2 + 1];
		    data[i * 2 + 1] = data[i];
		    data[i] = temp;
		    i = i * 2 + 1;
		}
		else{
		    return;
		}
	    }
	    else{
		if(data[i] * n < data[i * 2] * n){
		    int temp = data[i * 2];
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
