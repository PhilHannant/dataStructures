public class Stack<T> extends LinkedList<T> {

    private Node<T> root;

    public Stack(T rootData){
        super(rootData);
    }

    public void push(T data){
        addNode(data);
    }

    public Node<T> pop(){
        if(!isEmpty()) {
            Node<T> lastNode = findLastNode();
            deleteNode(getSize() - 1);
            return lastNode;
        } else {
            return null;
        }
    }

    public Node<T> peek(){
        if(!isEmpty()) {
            return findLastNode();
        } else {
            return null;
        }
    }

}
