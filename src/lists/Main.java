package lists;

import lists.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>("a");
        ll.addNode("b");
        ll.addNode("c");
        ll.addNode("d");
        ll.addNode("e");
        ll.printList();
        System.out.println(ll.getSize());
        ll.reverseList();
        ll.printList();
        ll.insertNode("insert", 3);
        ll.printList();
        ll.deleteNode(2);
        System.out.println("deleting");
        ll.printList();

        System.out.println("stack");
        Stack<Integer> s = new Stack<Integer>(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.peek().getData());
        s.pop();
        s.pop();
        System.out.println(s.peek().getData());
        s.pop();
        s.pop();
        System.out.println(s.peek().getData());




        System.out.println("queue");
        Queue<Integer> q = new Queue<Integer>(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        System.out.println(q.peek().getData());
        System.out.println(q.deQueue().getData());
        System.out.println(q.deQueue().getData());
        System.out.println(q.peek().getData());
        q.deQueue();
        q.deQueue();
        System.out.println(q.peek().getData());
        q.deQueue();
        q.deQueue();
        System.out.println(q.isEmpty());


        System.out.println("HashMap");
        HashMap hm = new HashMap(16);
        hm.add("vishal", 10);
        hm.add("vishal1", 20);
        System.out.println(hm.contains("vishal1"));


    }
}
