package lists;

public class LinkedList<T> {

    private Node<T> root;

    public LinkedList(T rootData){
        if (root == null) {
            this.root = new Node<T>(rootData, null);
        }
    }

    public Boolean isEmpty(){
        if(root == null){
            return true;
        } else {
            return false;
        }
    }

    public T getData(Node<T> node){
        return node.data;
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
            System.out.print(start.data + " ");
            start = start.next;
        }
        System.out.println("");
    }

    public Boolean insertNode(T data, int position){
        if (position >= getSize()){
            return false;
        } else {
            insertNodeHelper(data, position, 0, root);
            return true;
        }

    }

    public void insertNodeHelper(T data, int position, int node, Node<T> currentNode){
        if(node == position){
            Node<T> newNode = new Node<T>(data, currentNode.next);
            currentNode.next = newNode;
         } else {
            node++;
            insertNodeHelper(data, position, node, currentNode.next);
        }
    }

    public Node<T> moveRoot(){
        if(root == null){return null;}
        Node<T> returnNode = root;
        if(!isEmpty() && getSize() != 1){
            root = root.next;
            return returnNode;
        } else {
            root = null;
            return returnNode;
        }
    }

    public Boolean deleteNode(int position){
        if (position > getSize()){
            return false;
        } else {
            deleteNodeHelper(position, 0, root, null);
            return true;
        }
    }

    public void deleteNodeHelper(int position, int node, Node<T> currentNode, Node<T> previous){
        if(node == position){
              previous.next = currentNode.next;
        } else {
            node++;
            deleteNodeHelper(position, node, currentNode.next, currentNode);
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
        root = reverseList(root);
    }

    public Node<T> reverseList(Node<T> node){
        Node<T> previous = null;
        Node<T> current = node;
        Node<T> nextNode = root.next;
        while(current != null){
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        node = previous;
        return node;
    }

    public boolean detectCycle(){
        return detectCycle(root);
    }

    //Uses Flloyd's cycle detection algorithm
    public boolean detectCycle(Node<T> node) {
        Node<T> slow = node;
        Node<T> fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
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

    public T getRootData(){
        return root.data;
    }

    public Node<T> getRoot(){
        return root;
    }

//    public int mergeLists(Node node1, Node node2){
//        Stack<Node> list1 = getStack(node1);
//        Stack<Node> list2 = getStack(node2);
//        int lastValue = 0;
//        while (!list1.isEmpty() || !list2.isEmpty()){
//            lastValue = list1.peek().data;
//            if(list1.peek().data != list2.peek().data){
//                return lastValue;
//            } else {
//                lastValue = list1.pop().data;
//                list2.pop();
//            }
//        }
//        return -1
//    }
//
//    public Stack<Node> getStack(Node node){
//        Stack<Node> s = new Stack<>();
//        while(node != null){
//            s.push(node);
//            node = node.next;
//        }
//        return s;
//
//    }

    class Node<T>{

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
