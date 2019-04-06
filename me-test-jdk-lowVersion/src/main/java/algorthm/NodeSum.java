package algorthm;

/**
 * 两个链表
 * @author zhaohaojie
 * @date 2019-03-15 18:17
 */
public class NodeSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode finalNode = new ListNode(0);
        ListNode tmp2 = new ListNode(0);
        tmp2.next = null;

        int plx = 0;
        if (l1 ==null && l2 != null){
            plx = l2.val;
        }
        if (l2 ==null && l1 != null){
            plx = l1.val;
        }
        if (l1!=null && l2!=null){
            plx = l1.val+l2.val;
        }
        if(plx>9){
            String str =Integer.valueOf(plx).toString().substring(1,2);
            finalNode.val = Integer.parseInt(str);
            if(l2.next != null ){
                l2.next.val = l2.next.val+1;
            }else if(l1.next != null){
                l1.next.val = l1.next.val+1;
            }else if(l1.next ==null && l2.next==null){
                ListNode tmp = new ListNode(1);
                tmp.next=null;
                finalNode.next = tmp;
                return finalNode;
            }

        }else{
            finalNode.val = plx;
        }

        if (l1.next ==null && l2.next == null){
            finalNode.next = null;
            return finalNode;
        }
        if(l1.next == null){
            finalNode.next = addTwoNumbers(l2.next,tmp2);
            return finalNode;
        }
        if (l2.next ==null){
            finalNode.next=  addTwoNumbers(l1.next,tmp2);
            return finalNode;
        }
        finalNode.next = addTwoNumbers(l1.next,l2.next);
        return finalNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode first_2 = new ListNode(8);
        ListNode first_3 = new ListNode(9);
        first.next = first_2;
        first_2.next = first_3;
        first_3.next = null;

        ListNode sec = new ListNode(9);
        ListNode sec_2 = new ListNode(2);
        ListNode sec_3 = new ListNode(3);
        sec.next = sec_2;
        sec_2.next = sec_3;
        sec_3.next = null;
        NodeSum test= new NodeSum();
        ListNode node = test.addTwoNumbers(first,sec);
        System.out.println(node);
    }
}

