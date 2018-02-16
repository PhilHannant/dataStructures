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

    public Boolean insertNode(T data, int position){
        if (position > getSize()){
            return false;
        } else {
            insertNodeHelper(data, position, 0, root);
            return true;
        }

    }

    public void insertNodeHelper(T data, int position, int node, Node<T> currentNode){
        System.out.println(node);
        if(node == position){
            Node<T> newNode = new Node<T>(data, currentNode.next);
            currentNode.next = newNode;
         } else {
            node++;
            insertNodeHelper(data, position, node, currentNode.next);
        }
    }

    public int getSize(){
        int size = 0;
        Node<T> start = root;
        while(start != null){
            size++;
            start = start.next;
        }
        return size;
    }

    public void shiftList(int num){
        Node<T> last = findLastNode();
        for(int i = 0; i < num; i++){
            last.next = root;
            root = last;
            removeNext(last);
            last = findLastNode();
        }
    }

    public void reverseList(){
        Node<T> previous = null;
        Node<T> nextNode = root.next;
        while(nextNode != null){
            root.next = previous;
            previous = root;
            root = nextNode;
            nextNode = nextNode.next;
            root.next = previous;

        }
    }

    public void removeNext(Node<T> removeNode){
        removeNextHelper(root, removeNode);

    }
    public void removeNextHelper(Node<T> node, Node<T> removeNode){
        if (node.next.equals(removeNode)){
            node.next = null;
        } else {
            removeNextHelper(node.next, removeNode);
        }
    }

    public Node<T> findPrevious(Node<T> node, Node<T> nodeToFind){
        if(node.next.equals(nodeToFind)){
            return node;
        } else {
            return findPrevious(node.next, nodeToFind);
        }
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
