package tree;

public class Heap {

    private int size;
    private int capacity;
    private Integer[] harr;

    public Heap(int capacity){
        this.capacity = capacity;
        harr = new Integer[capacity];
        size = 0;
    }


    public int getMin(){
        return harr[0];
    }

    public int parent(int index){
        return (index-1)/2;
    }

    public int leftChild(int index){
        return (2*index+1);
    }

    public int rightChild(int index){
        return (2*index+2);
    }

    public void insertKey(Integer key){
        if(size == capacity){
            return;
        }
        harr[size] = key;
        size++;
        if(harr[parent(size-1)] > key){
            swap(size-1);
        }
    }

    public void swap(int index){
        int parent = harr[parent(index)];
        int child = harr[index];
        while
    }

}
