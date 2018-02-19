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

    public int getParent(int index){
        return (index-1)/2;
    }

    public int getLeftChild(int index){
        return (2*index+1);
    }

    public int getRightChild(int index){
        return (2*index+2);
    }

    public void insertKey(Integer key){
        if(size == capacity){
            return;
        }
        harr[size] = key;
        size++;
        int parent = harr[getParent(size-1)];
        int parentKey = getParent(size-1);
        if(parent > key){
            while(parent > key){
                swap(size-1, parentKey);
                parent = harr[parentKey];
            }


        }
    }

    public void swap(int index, int parent){
        int temp = harr[index];
        harr[index] = harr[parent];
        harr[parent] = temp;
    }

}
