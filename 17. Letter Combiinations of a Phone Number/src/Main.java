import java.sql.Struct;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String digits = "232345345334";

        List<String> results = new ArrayList<>();
        if(digits.isEmpty()){
            return;
        }

        Map<Integer, String> cypher = new HashMap<>();
        cypher.put(2, "abc");
        cypher.put(3, "def");
        cypher.put(4, "ghi");
        cypher.put(5, "jkl");
        cypher.put(6, "mno");
        cypher.put(7, "pqrs");
        cypher.put(8, "tuv");
        cypher.put(9, "wxyz");

        class Combination{
            public Integer index;
            public String letters;

            public Combination(Integer index, String letters) {
                this.index = index;
                this.letters = letters;
            }
        }

        Stack<Combination> stack = new Stack<>();
        stack.add(new Combination(0, ""));

        while (!stack.isEmpty()){
            Combination currentComb = stack.pop();
            if(currentComb.index == digits.length()){
                results.add(currentComb.letters);
            } else {
                String currentLetters = cypher.get(Character.getNumericValue(digits.charAt(currentComb.index)));
                for (int i = 0; i < currentLetters.length(); i++) {
                    stack.add(new Combination(currentComb.index+1, currentComb.letters + currentLetters.charAt(i)));
                }
            }
        }
        System.out.println(results);
    }
}
