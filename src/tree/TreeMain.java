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
        t.addNode(2);
        System.out.println(t.countNodes());
        t.printInOrder();
        t.printPreOrder();
        t.printPostOrder();
        System.out.println("min=" + t.getMin());
        System.out.println("max=" + t.getMax());
        System.out.println("depth="+t.deepestNode());
        System.out.println(t.getData(t.findNode(26)));
        System.out.println(t.getData(t.findNode(10)));
        //System.out.println(t.getData(t.findNode(100)));
        t.deleteNode(15);
        t.printInOrder();
        System.out.println(t.checkBST());
        t.printInOrder();
        //t.invertTree();
        t.printInOrder();
        System.out.println("f="+t.getData(t.find(10)));
        System.out.println("fN="+t.getData(t.findNode(26)));

        System.out.println(t.deepestNode());

        System.out.println(t.getData(t.getDeep()));

        System.out.println(t.countNodes());





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
        h.decreaseKey(3, 2);
        System.out.println("decrease");
        h.print();
        h.deleteKey(2);
        System.out.println("delete");
        h.print();

        System.out.println((2-1)/2);
        System.out.println((1-1)/2);



    }
}
