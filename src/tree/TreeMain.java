package tree;

public class TreeMain {

    public static void main(String[] args){
        System.out.println("tree");
        Tree t = new Tree(15);
        t.addNode(2);
        t.addNode(23);
        t.addNode(22);
        t.addNode(26);
        t.addNode(1);
        t.addNode(6);
        t.addNode(10);
        t.printInOrder();
        t.printPreOrder();
        t.printPostOrder();
        System.out.println("min=" + t.getMin());
        System.out.println("max=" + t.getMax());

        System.out.println("heap");
        Heap h = new Heap(20);
        h.insertKey(30);
        System.out.println("min="+h.getMin());
        h.insertKey(2);
        System.out.println("min="+h.getMin());
        h.insertKey(15);
        System.out.println("min="+h.getMin());
        h.insertKey(5);
        System.out.println("min="+h.getMin());
        h.insertKey(4);
        System.out.println("min="+h.getMin());
        h.insertKey(45);
        System.out.println("min="+h.getMin());
        h.print();
        System.out.println("extract="+h.extractMin());
        h.print();

    }
}
