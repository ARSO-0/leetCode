public class Main {
    public static void main(String[] args) {
        class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(5)));

        ListNode mergedHead = new ListNode(-1);
        ListNode currentNode = mergedHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }

        currentNode.next = list1 == null ? list2 : list1;

        //return mergedHead.next;

        mergedHead = mergedHead.next;
        while(mergedHead != null){
            System.out.println(mergedHead.val);
            mergedHead = mergedHead.next;
        }
    }

}