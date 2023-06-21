public class Main {
    public static void main(String[] args) {


        String s = "PAYPALISHIRING";
        int numRows = 4;


        if(numRows == 1){
            System.out.println("return s;");
        }
        StringBuilder outputString = new StringBuilder();
        int step = numRows * 2 - 2;
        for (int i = 0; i < numRows; i++) {

            if(i==0 || i == numRows - 1){
                for (int j = i; j < s.length(); j=j+step) {
                    outputString.append(s.charAt(j));
                }
            } else{
                int k = i;
                boolean goesDown = true;
                int stepDown = 2 * (numRows - 1 - i);
                int stepUp = step - stepDown;
                while(k < s.length()){
                    outputString.append(s.charAt(k));
                    if(goesDown){
                        k = k + stepDown;
                    } else {
                        k = k + stepUp;
                    }
                    goesDown = !goesDown;
                }
            }

        }
        System.out.println(outputString.toString());
    }
}