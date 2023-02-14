public class Main {
    public static void main(String[] args) {
        int x = 1534236469;

        StringBuilder  input = new StringBuilder(String.valueOf(x));
        StringBuilder output = new StringBuilder();
        if(input.charAt(0) == '-'){
            output.append("-");
            input.deleteCharAt(0);
        }

        for (int i = input.length() - 1; i >= 0; i--) {
            if(input.charAt(i) == '0'){
                input.deleteCharAt(i);
            } else {
                break;
            }
        }

        for (int i = input.length() - 1; i >= 0; i--) {
            output.append(input.charAt(i));
        }

        System.out.println(output);
        try {
            System.out.println(Integer.parseInt(output.toString()));
        } catch (NumberFormatException e){
            System.out.println(0);
        }
    }
}
