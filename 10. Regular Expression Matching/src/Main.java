public class Main {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";

       int sIndex = 0;
        Character currentChar = null;
       Character prevChar = null;
       Character currentToken = null;
       Character prevToken = null;
       boolean astrixFlag = false;

        for(int i = 0; i < p.length(); i++) {
            currentToken = p.charAt(i);
            if(i+1 < p.length() && p.charAt(i+1) == '*'){
                astrixFlag = true;
            } else {
                astrixFlag = false;
            }

            currentChar = s.charAt(sIndex);

            switch (currentToken) {
                case '.':
                    sIndex++;
                    prevToken = currentToken;
                    prevChar = currentChar;
                    break;
                case '*':
                    break;
                default:
                    if(astrixFlag == true && )
                    break;
            }


        }
    }
}
