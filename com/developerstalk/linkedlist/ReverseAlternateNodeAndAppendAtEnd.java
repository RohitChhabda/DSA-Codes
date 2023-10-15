package com.developerstalk.linkedlist;

class ReverseAlternateNodeAndAppendAtEnd
{
    public static void rearrange(ListNode odd)
    {
    	ListNode evenHead = odd.next;
    	ListNode oddHead = odd;
    	ListNode even = odd.next;
        
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        //System.out.println(odd.data);
        odd.next = reverse(evenHead);
        
    }
    
    public static ListNode reverse(ListNode head){
    	ListNode prev=null;
    	ListNode current = head;
        while(current != null){
            //System.out.println("Current Data" +current.data);
        	ListNode next = current.next;
            current.next=prev;
            prev=current;
            current = next;
        }
        return prev;
    }
}
