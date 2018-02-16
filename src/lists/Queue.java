package lists;



public class Queue<T> extends LinkedList<T> {

    private Node<T> root;

    public Queue(T rootData){
        super(rootData);
    }

    public void enQueue(T data){
        addNode(data);
    }

    public Node<T> deQueue(){
        return moveRoot();
    }



    public Node<T> peek(){
        if(!isEmpty()) {
            return getRoot();
        } else {
            return null;
        }
    }
}
