public class Recursion{ 
    public static String name(){
	return "Sharapov,Jeremy";
    }
    
    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 1 || n == 0){
	    return n;
	}
	else{
	    return guesser(n, 1);
	}
    }

    public static double guesser(double n, double guess){
	if(Math.abs(guess * guess - n) < .0000000001){
	    return guess;
	}
	else{
	    return guesser(n, (n / guess + guess) / 2);
	}
    }
}
