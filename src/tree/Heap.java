package tree;

public class Heap {

    private int size;
    private int capacity;
    private Object[] harr;

    public Heap(int capacity){
        this.capacity = capacity;
        harr = new Object[capacity];
    }
}
