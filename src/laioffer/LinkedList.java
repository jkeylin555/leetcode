package laioffer;

public class LinkedList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        LinkedList linkedList = new LinkedList();
        int res = linkedList.getLength(listNode1);
        System.out.println(res);


    }



     static class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            this.next =  null;
        }
    }

    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }



}

////        ListNode listNode1 = new ListNode(1);
//         doSomething();
//         LinkedList linkedList = new LinkedList();
