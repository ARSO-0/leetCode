public class Main {
    public static void main(String[] args) {
        int x = 112112;

        System.out.println(String.valueOf(x).equals(new StringBuilder(String.valueOf(x)).reverse().toString()));
    }
}