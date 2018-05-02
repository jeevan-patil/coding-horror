package xyz.jeevan.code.collections.lists;

import xyz.jeevan.code.collections.lists.objects.LinkedList;

/**
 * Implement custom linked list and find middle element of that list.
 *
 * @author jeevan
 */
public class MiddleOfLinkedList {

  public static void main(String args[]) {
    //creating LinkedList with 5 elements including head
    LinkedList linkedList = new LinkedList();
    linkedList.add(new LinkedList.Node("1"));
    linkedList.add(new LinkedList.Node("2"));
    linkedList.add(new LinkedList.Node("3"));
    linkedList.add(new LinkedList.Node("4"));
    linkedList.add(new LinkedList.Node("5"));

    //finding middle element of LinkedList in single pass
    LinkedList.Node head = linkedList.head();
    LinkedList.Node current = head;
    LinkedList.Node middle = head;

    int length = 0;
    while (current.next() != null) {
      length++;
      if (length % 2 == 0) {
        middle = middle.next();
      }
      current = current.next();
    }

    if (length % 2 == 1) {
      middle = middle.next();
    }

    System.out.println("length of LinkedList: " + length);
    System.out.println("middle element of LinkedList : " + middle);
  }
}
