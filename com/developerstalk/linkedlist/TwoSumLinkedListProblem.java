package com.developerstalk.linkedlist;

public class TwoSumLinkedListProblem {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int reminder=0;
        ListNode root = new ListNode();
        ListNode tempNode = root;
        ListNode previousNode=root;
        while(l1!= null && l2 != null){
            int sum = l1.val + l2.val + reminder; 
            reminder = sum / 10; 
            sum = sum % 10; 
            tempNode.val = sum; 
            tempNode.next = new ListNode();
            previousNode = tempNode;
            tempNode = tempNode.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        
        // when l2 is null 
        while(l1 != null){
            int sum = l1.val + reminder; 
            reminder = sum / 10; 
            sum = sum % 10; 
            tempNode.val = sum; 
            tempNode.next = new ListNode();
            previousNode = tempNode;
            tempNode = tempNode.next;

            l1 = l1.next;
        }
        
        // when l1 is null
        while(l2 != null){
            int sum = l2.val + reminder; 
            reminder = sum / 10; 
            sum = sum % 10; 
            tempNode.val = sum; 
            tempNode.next = new ListNode();
            previousNode = tempNode;
            tempNode = tempNode.next;

            l2 = l2.next;
        }

        if(reminder > 0){
        tempNode.val = reminder; 
        tempNode.next = null;
        }else{
        	// if reminder is 0 then no need of having next node hence removing it
            previousNode.next = null;
        }

        return root;
    }

}
