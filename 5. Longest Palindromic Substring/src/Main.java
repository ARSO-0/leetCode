import java.util.ArrayList;

public class Main {

    public static boolean isPalindromic(ArrayList<Character> charSet){
        int j = charSet.size() - 1;
        for(int i = 0; i < charSet.size(); i++){
            if(i == j){
                break;
            }
            if(charSet.get(i) != charSet.get(j)){
                return false;
            }
            j--;
        }
       return true;
    }

    public static void main(String[] args) {
        String s = "ac";

        ArrayList<Character> charSet = new ArrayList<>();
        ArrayList<Character> maxSet = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            charSet.add(s.charAt(i));
            if(charSet.size() > maxSet.size() && isPalindromic(charSet)){
                maxSet = new ArrayList<>(charSet);
            }
            for(int j = i + 1; j < s.length(); j++){
                charSet.add(s.charAt(j));
                if(charSet.size() > maxSet.size() && isPalindromic(charSet)){
                    maxSet = new ArrayList<>(charSet);
                }
            }
            charSet.clear();
        }
        StringBuilder result = new StringBuilder();
        maxSet.forEach(character -> {
            result.append(character);
        });
        System.out.println(result.toString());
    }
}
