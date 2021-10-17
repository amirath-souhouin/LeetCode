/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.math.BigInteger;
import java.math.*;

 class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         BigInteger num1 = returnNumberfromListNode(l1);
         BigInteger num2 = returnNumberfromListNode(l2);
         BigInteger zero = new BigInteger("0") ;
         BigInteger r = num1.add(num2);
         ListNode tmp  = new ListNode(0);
         ListNode current = tmp;
         int res = zero.compareTo(r);
         int count = r.toString().length();
         if(res == 0  ){
             current.next = new ListNode(0);
         }
         else{
             System.out.println(count);
             do {
             
                     
                 BigInteger value = r.mod(new BigInteger("10"));
                 current.next = new ListNode(value.intValue()) ;
                 current = current.next;
                 r = r.divide(new BigInteger("10"));
                 count --;
                 
            } while(count >0 );
             
        }
        
        return tmp.next;
    }
    private BigInteger returnNumberfromListNode(ListNode l) {//Retrieve the number from linkedList
       int lengthOfNode = countNumberofNode(l);
        BigInteger value = new BigInteger("0");
        BigInteger ten = new BigInteger("10");

        for(int i = 0; i <= lengthOfNode; i++){
             if(l != null){
                BigInteger t = new BigInteger(Integer.toString(l.val));
                value = value.add(ten.pow(i).multiply(t));
                 l = l.next;
             }
        }
        return value;
    }
    private int countNumberofNode (ListNode l){//return de numberofNode of a ListNode
        int count = 0;
        
        while(l.next != null){
            l = l.next;
            count++;
        }
        return count;
    }
}
