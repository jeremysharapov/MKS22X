import java.util.*;
public class Merge{
    
    public static void mergesort(int[] ary){
	if (ary.length <= 1){
	    return;
	}
	else{
	    int[] left = new int[ary.length / 2];
	    int[] right = new int[ary.length - left.length];
	    for (int i = 0; i < ary.length; i++){
		if (i < left.length){
		    left[i] = ary[i];
		}
		else{
		    right[i - left.length] = ary[i];
		}
	    }
	    mergesort(left);
	    mergesort(right);
	    merge(left, right, ary);
	}
    }
    
	

    public static void merge(int[] a, int[] b, int[] destination){
	int aIndex = 0;
	int bIndex = 0;
	for (int i = 0; i < destination.length; i++){
	    if (aIndex >= a.length){
		destination[i] = b[bIndex];
		bIndex++;
	    }
	    else if (bIndex >= b.length){
		destination[i] = a[aIndex];
		aIndex++;
	    }
	    else if (a[aIndex] < b[bIndex]){
		destination[i] = a[aIndex];
		aIndex++;
	    }
	    else{
		destination[i] = b[bIndex];
		bIndex++;
	    }
	}
    }
}
