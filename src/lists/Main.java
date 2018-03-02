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
        HashMap hm = new HashMap(10);
        hm.add("vishal", 10);
        hm.add("vishal1", 20);
        System.out.println(hm.contains("vishal1"));
        hm.add("}", 30);
        hm.add("a", 1);
        hm.add("!", 100);
        hm.add("b", 110);
        hm.add("c", 120);
        hm.add("d", 130);
        hm.add("e", 140);
        hm.add("z", 150);
        hm.add("h", 160);
        hm.add("1", 100);
        hm.add("4", 100);
        hm.add("5", 100);
        hm.add("6", 100);
        hm.add("7", 100);
        System.out.println(hm.contains("vishal1"));
        System.out.println(hm.delete("vishal"));
        System.out.println(hm.contains("vishal1"));
        System.out.println(hm.delete("c"));
        System.out.println(hm.contains("c"));
        System.out.println(hm.contains("7"));
        hm.printHashMap();


    }
}
