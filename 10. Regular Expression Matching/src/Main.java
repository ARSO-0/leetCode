public class Main {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";

        if(p.length() > s.length()){
            System.out.println("false");
        }

        boolean result = false;
        int j = 0;
        for (int i = 0; i < p.length(); i++) {
            if(Character.isAlphabetic(p.charAt(i)) && p.charAt(j) == s.charAt(i)){
                j++;
                continue;
            } else if(p.charAt(i) == '.'){

            } else if(p.charAt(i) == '*' && ((p.charAt(i-1) == s.charAt(j)) || (p.charAt(i-1) == '.'))){
                j++;
                continue;
            }
            break;
        }
    }
}
