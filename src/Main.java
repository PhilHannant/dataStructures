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


    }
}
