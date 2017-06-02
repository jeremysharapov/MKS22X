import java.util.Stack;
public class StackCalc{

    public static double eval(String s){
	String[] tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>();
	for(String token : tokens){
	    if(isOp(token)){
		values.push(apply(values.pop(), values.pop(), token));
	    }
	    else{
		values.push(Double.parseDouble(token));
	    }
	}
	return values.pop();
    }

    private static boolean isOp(String s){
	return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%");
    }

    private static double apply(double b, double a, String op){
       	switch(op){
	case "+":
	    return a + b;
	case "-":
	    return a - b;
	case "*":
	    return a * b;
	case "/":
	    return a / b;
	case "%":
	    return a % b;
	default:
	    throw new IllegalArgumentException();
	}
    }
}
