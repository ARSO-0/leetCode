import java.util.ArrayList;

public class Main {

     public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public static void main(String[] args) {

        //ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        //ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        ArrayList<Integer> results = new ArrayList<>();
        int currentL1 = l1.val;
        int currentL2 = l2.val;
        int carryFlag = 0;
        int currentResult = 0;
        while (true){
           currentResult = currentL1 + currentL2 + carryFlag;
           if(currentResult >= 10){
               carryFlag = 1;
               currentResult -= 10;
           } else {
               carryFlag = 0;
           }
           results.add(currentResult);
           if(l1.next == null && l2.next == null && carryFlag == 0){
               break;
           }
           if(l1.next != null){
               l1 = l1.next;
               currentL1 = l1.val;
           } else {
               currentL1 = 0;
           }

            if(l2.next != null){
                l2 = l2.next;
                currentL2 = l2.val;
            } else {
                currentL2 = 0;
            }
        }
        ListNode listResult = new ListNode(results.get(0));
        ListNode currentNode = listResult;
        for (int i = 1; i < results.size(); i++) {
            currentNode.next = new ListNode(results.get(i));
            currentNode = currentNode.next;
        }
        System.out.println(results);
    }
}
