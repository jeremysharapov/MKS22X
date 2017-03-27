import java.util.*;
public class Quick{


    public static int[] part(int[] data, int start, int end){
        int pivotIndex = new Random().nextInt(end - start + 1) + start;
	int pivot = data[pivotIndex];
	swap(data, pivotIndex, start);
	pivotIndex = start;
	int lt = start;
	int i = start + 1;
	int gt = end;
	while (i <= gt){
	    if (data[i] == pivot){
		i++;
	    }
	    else if (data[i] < pivot){
		swap(data, i, lt);
		lt++;
		i++;
	    }
	    else{
		swap(data, i, gt);
		gt--;
	    }
	}
	int[] range = new int[2];
	range[0] = lt;
	range[1] = gt;
	return range;
    }

    public static void swap(int[] data, int here, int there){
	int temp = data[here];
	data[here] = data[there];
	data[there] = temp;
    }
    
    public static int quickselect(int[]data, int k){
	int start = 0;
	int end = data.length - 1;
	int[] guess = part(data, start, end);
	while (!(guess[0] <= k && k <= guess[1])){
	    if (guess[0] > k){
		end = guess[0] - 1;
	    }
	    if (guess[1] < k){
		start = guess[1] + 1;
	    }
	    guess = part(data, start, end);
	}
	return data[guess[0]];
    }

    public static void quicksort(int[] data){
	quicksortH(data, 0, data.length - 1);
    }

    public static void quicksortH(int[] data, int start, int end){
	if (start < end){
	    int[] splitter = part(data, start, end);
	    quicksortH(data, start, splitter[0]);
	    quicksortH(data, splitter[1] + 1, end);
	}
    }
}
