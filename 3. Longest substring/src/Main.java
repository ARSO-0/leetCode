import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        //String s = "abcabcbb";
        //String s = "bbbbb";
        String s ="pwwkew";
        //String s = " ";

        ArrayList<Character> charSet = new ArrayList<>();
        ArrayList<Character> maxSet = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            char val = s.charAt(i);
            if(!charSet.contains(val)){
                charSet.add(val);
            } else {
                if(charSet.size() > maxSet.size()){
                    maxSet = new ArrayList<>(charSet);
                }
                charSet.add(val);
                charSet = new ArrayList<>(charSet.subList(charSet.indexOf(val)+1, charSet.size()));
            }
            if(i+1 == s.length()){
                if(charSet.size() > maxSet.size()){
                    maxSet = new ArrayList<>(charSet);
                }
            }
        }
        System.out.println(maxSet);
        System.out.println(maxSet.size());
    }
}
