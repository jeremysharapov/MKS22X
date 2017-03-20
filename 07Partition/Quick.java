import java.util.*;
public class Quick{


    public static int part(int[] data, int start, int end){
        int pivotIndex = new Random().nextInt(end - start) + start;
	int pivot = data[pivotIndex];
	Swap(data, pivotIndex, end);
	pivotIndex = start;
	for(int i = start; i < end; i++){
	    if(data[i] < pivot){
		Swap(data, i, pivotIndex);
		pivotIndex++;
	    }
	}
	Swap(data, end, pivotIndex);
	return pivotIndex;
    }

    public static void Swap(int[] data, int here, int there){
	int temp = data[here];
	data[here] = data[there];
	data[there] = temp;
    }
    
    public static int quickselect(int[]data, int k){
	int start = 0;
	int end = data.length - 1;
	int guess = part(data, start, end);
	while (k != guess){
	    if (guess > k){
		end = guess - 1;
	    }
	    if (guess < k){
		start = guess + 1;
	    }
	    guess = part(data, start, end);
	}
	return data[guess];
    }

    public static void main(String[] args){
	int[] bob = {8, 5, 0, 9, 3, 1, 4, 6, 2, 7};
	System.out.println(quickselect(bob, 9));
    }
}
