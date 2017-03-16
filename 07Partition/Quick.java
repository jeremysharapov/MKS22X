import java.util.*;
public class Quick{


    public static int part(int[] data, int start, int end){
        int pivotIndex = new Random().nextInt(end - start + 1) + start;
	int pivot = data[pivotIndex];
	data[pivotIndex] = data[start];
	data[start] = pivot;
	pivotIndex = start;
	for(int i = start + 1; i < end; i++){
	    if(data[i] < pivot){
		data[pivotIndex] = data[i];
		data[i] = pivot;
		pivotIndex = i;
	    }
	}
	return pivotIndex;
    }


    public static int quickselect(int[]data, int k){
	int start = 0;
	int end = data.length - 1;
	int guess = part(data, start, end);
	while (k != guess + 1){
	    if (guess + 1 > k){
		end = guess - 1;
	    }
	    if (guess + 1 < k){
		start = guess + 1;
	    }
	    guess = part(data, start, end);
	}
	return data[guess];
    }
}
