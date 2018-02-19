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

        int parentKey = size-1;
        System.out.println("pkv="+harr[parentKey] + "k="+key);
        System.out.println("pk="+parentKey);
        System.out.println(harr[parentKey] > key);
        while(harr[parentKey] > key && parentKey != 0){
            System.out.println("parentKey="+parentKey);
            swap(size-1, parentKey);
            parentKey = getParent(parentKey);
        }
    }

    public void print(){
        for(int i = 0; i < size; i++){
            System.out.println(harr[i]);
        }
    }

    public void swap(int index, int parent){
        int temp = harr[index];
        harr[index] = harr[parent];
        System.out.println("indeex="+harr[index]);
        harr[parent] = temp;
        System.out.println("parent="+harr[parent]);
    }

}
