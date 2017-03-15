import java.util.*;
public class Quiz2Redux{  
    
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help(words, s, 0, "");
	Collections.sort(words);
	return words;
    }
   
    private static void help(ArrayList<String> words, String s, int index, String sub){
	if(index == s.length()){
	    words.add(sub);
	    return;
	}
	help(words, s, index + 1, sub);
	help(words, s, index + 1, sub + s.charAt(index));
    }
}

