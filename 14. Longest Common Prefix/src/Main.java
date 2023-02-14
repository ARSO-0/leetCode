public class Main {

    public static void main(String[] args) {
        String[] strs = {"aaa","","aaa"};

        // Horizontal scanning
//        StringBuilder prefix = new StringBuilder(strs[0]);
//        for (int i = 1; i < strs.length; i++) {
//            StringBuilder temp = new StringBuilder();
//            for (int j = 0; j < prefix.length(); j++) {
//                if(j >= strs[i].length()){
//                    break;
//                }
//                if(strs[i].charAt(j) == prefix.charAt(j)){
//                    temp.append(prefix.charAt(j));
//                } else {
//                    break;
//                }
//            }
//            if(temp.isEmpty()){
//                System.out.println("''");
//                break;
//            }
//            prefix = temp;
//        }
//        System.out.println(prefix.toString());


        // Vertical scanning

        StringBuilder prefix = new StringBuilder("");
        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length()){
                    break;
                }
                if(strs[j].charAt(i) != currentChar){
                    break; // return
                }
            }
            System.out.println(currentChar);
            prefix.append(currentChar);
        }
        // return prefix.toString();
    }
}
