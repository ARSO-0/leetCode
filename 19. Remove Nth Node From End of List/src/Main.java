public class Main {

    public static void main(String[] args) {

          //Definition for singly-linked head.
        class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

        ListNode head = new ListNode();

        int[] values = new int[]{1,2};
        int n = 2;


        // init list
        head.val = values[0];
        ListNode currenNode = head;
        for (int i = 1; i < values.length; i++) {
            ListNode nextNode = new ListNode(values[i]);
            currenNode.next = nextNode;
            currenNode = nextNode;
        }

//        currenNode = head;
//        for(int i = 0; i < values.length; i++){
//            System.out.println(currenNode.val);
//            currenNode = currenNode.next;
//        }



        // calculate list length
        int listLength = 0;
        currenNode = head;
        while(currenNode != null){
            listLength++;
            currenNode = currenNode.next;
        }

        // Getting references to nearby elements
        int removeIndex = listLength - n;
        currenNode = head;
        ListNode preRemoveNode = null;
        ListNode postRemoveNode = null;
        for(int i = 0; i < listLength; i++){
            if(i == removeIndex - 1){
                preRemoveNode = currenNode;
            }
            if(i == removeIndex + 1){
                postRemoveNode = currenNode;
            }
            currenNode = currenNode.next;
        }

        // removing reference to deleted element
        if(preRemoveNode != null && postRemoveNode != null){
            preRemoveNode.next = postRemoveNode;
        } else if(preRemoveNode == null && postRemoveNode != null){
            head = postRemoveNode;
        } else if(preRemoveNode != null && postRemoveNode == null){
            preRemoveNode.next = null;
        }else {
            System.out.println("[]");
        }


        // output
        currenNode = head;
        for (int i = 0; i <listLength - 1; i++) {
            System.out.println(currenNode.val);
            currenNode = currenNode.next;
        }


    }
}
