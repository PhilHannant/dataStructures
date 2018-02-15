public class LinkedList<T> {

    private Node<T> root;

    public LinkedList(T rootData){
        if (root == null) {
            this.root = new Node<T>(rootData, null);
        }
    }

    public void addNode(T data){
        if (root == null){
            this.root = new Node<T>(data, null);
        } else {
            findLastNode().next = new Node<T>(data, null);
        }

    }

    public Node<T> findLastNode(){
        if(root.next == null){
            return root;
        } else {
            return findLastNodeHelper(root);
        }
    }

    public Node<T> findLastNodeHelper(Node<T> node){
        if(node.next == null){
            return node;
        } else {
            return findLastNodeHelper(node.next);
        }
    }

    public void printList(){
        Node<T> start = root;
        while(start != null){
            System.out.println(start.data);
            start = start.next;
        }
    }


    public void reverseList(){
        root = findLastNode();

    }


    private class Node<T>{

        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }

        public Node<T> getNext(Node<T> node){
            return node.next;
        }

        public void setNext(Node<T> node, Node<T> nextNode){
            node.next = nextNode;
        }

        public T getData(){
            return this.data;
        }
    }


}
