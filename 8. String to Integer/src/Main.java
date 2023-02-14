public class Main {

    public static void main(String[] args) {
        String s = "x   -042asd";

        StringBuilder output = new StringBuilder();
        int sign = 1;
        boolean numberStartFlag = false;
        for(int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);
            if(numberStartFlag == false){
                if(val == ' '){
                    continue;
                } else if(val == '+'){
                    numberStartFlag = true;
                    sign = 1;
                } else if(val == '-'){
                    numberStartFlag = true;
                    sign = -1;
                } else if (val == '0' && output.length() < 1){
                    numberStartFlag = true;
                } else if(Character.isDigit(val)){
                    numberStartFlag = true;
                    output.append(val);
                } else if(!Character.isDigit(val)){
                    break;
                }
                continue;
            }

            if(val == '0' && output.length() < 1){
                continue;
            } else if(Character.isDigit(val)){
                output.append(val);
            } else {
                break;
            }
        }

        if(output.isEmpty()){
            System.out.println(0);
        }
        try {
            System.out.println(Integer.parseInt(output.toString()) * sign);
        } catch (NumberFormatException ex){
            if(sign == 1){
                System.out.println(2147483647);
            } else {
                System.out.println(-2147483648);
            }
        }

    }
}
