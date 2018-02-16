package lists;

public class DoublyLinkedList<T> {

    private Node<T> root;

    public DoublyLinkedList(T rootData){
        if (root == null) {
            this.root = new Node<T>(rootData, null, null);
        }
    }

    public void addNode(T data){
        if (root == null){
            this.root = new Node<T>(data, null, null);
        } else {
            findLastNode().next = new Node<T>(data, null, findLastNodeHelper(root));
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
//        while(root.last != null){
//            end = end.last;
//        }
    }


    private class Node<T>{

        private T data;
        private Node<T> next;
        private Node<T> last;

        public Node(T data, Node<T> next, Node<T> last){
            this.data = data;
            this.next = next;
            this.last = last;
        }

        public Node<T> getNext(Node<T> node){
            return node.next;
        }

        public Node<T> getLast(Node<T> node){
            return node.last;
        }

        public void setNext(Node<T> node, Node<T> nextNode){
            node.next = nextNode;
        }

        public void setLast(Node<T> node, Node<T> lastNode){
            node.next = lastNode;
        }

        public T getData(){
            return this.data;
        }
    }


}
