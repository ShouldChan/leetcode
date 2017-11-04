package com.cxj.leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class addtwonumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resultList = new ListNode(0);
		ListNode p = l1, q = l2, temp = resultList;
		int sum = 0, carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			sum = x + y + carry;
			carry = sum / 10;
			temp.next = new ListNode(sum % 10);
			temp = temp.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		// last plus may >10
		if (carry > 0)
			temp.next = new ListNode(carry);
		return resultList.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(2);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		addtwonumbers at = new addtwonumbers();
		ListNode l = new ListNode(0);
		l = at.addTwoNumbers(l1, l2);
		System.out.println(l.val);
	}

}
