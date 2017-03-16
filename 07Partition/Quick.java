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

    public static void main(String[] args){
	int[] hi = {9, 0, 5, 3, 8, 6, 2, 1, 4, 7};
	System.out.println(part(hi, 2, 8));
    }
}
