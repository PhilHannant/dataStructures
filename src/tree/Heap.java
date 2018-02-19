package tree;

public class Heap {

    private int size;
    private int capacity;
    private int[] harr;

    public Heap(int capacity){
        this.capacity = capacity;
        harr = new int[capacity];
    }


    public int getMin(){
        return harr[0];
    }

    public int parent(int n){
        return (n-1)/2;
    }

    public int leftChild(int n){
        return (2*n+1);
    }

    public int rightChild(int n){
        return (2*n+2);
    }

    public void insertKey(){

    }

}
