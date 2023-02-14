import java.util.HashSet;
import java.util.Set;

public class Main {

    public static boolean hasDuplicates(char[] string){
        Set<Character> items = new HashSet<Character>();
        for(int i = 0; i < string.length; i++){
            if(string[i] == '.'){
                continue;
            }
            if(items.contains(string[i])) return true;
            items.add(string[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        char[][]board = new char[][]{{'.','4','.','.','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'},
                {'.','.','.','1','.','.','7','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','3','.','.','.','6','.'},
                {'.','.','.','.','.','6','.','9','.'},
                {'.','.','.','.','1','.','.','.','.'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','8','.','.','.','.','.'}};


        // rows
        for(int i = 0; i < 9; i++){
            char[] row = new char[9];
            for(int j = 0; j < 9; j++){
                row[j] = board[i][j];
            }
            if(hasDuplicates(row)){
                System.out.println("false");
                return;
            }
        }

        // columns
        for(int i = 0; i < 9; i++){
            char[] column = new char[9];
            for(int j = 0; j < 9; j++){
                column[j] = board[j][i];
            }
            if(hasDuplicates(column)){
                System.out.println("false");
                return;
            }

        }

        // box
        // 00 03 06
        // 30 33 36
        // 60 63 66
        for(int i = 0; i <= 6; i+=3){
            char[] box = new char[9];
            for(int j = 0; j <= 6; j+=3){
                box[0] = board[i][j];
                box[1] = board[i][j+1];
                box[2] = board[i][j+2];
                box[3] = board[i+1][j];
                box[4] = board[i+1][j+1];
                box[5] = board[i+1][j+2];
                box[6] = board[i+2][j];
                box[7] = board[i+2][j+1];
                box[8] = board[i+2][j+2];
                if(hasDuplicates(box)){
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println("true");
    }
}
