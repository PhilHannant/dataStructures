package tree;

public class Heap {

    private Integer size;
    private Integer capacity;
    private Integer[] harr;

    public Heap(Integer capacity){
        this.capacity = capacity;
        harr = new Integer[capacity];
        size = 0;
    }


    public int getMin(){
        return harr[0];
    }

    public int getParent(Integer index){
        return (index-1)/2;
    }

    public int getLeftChild(Integer index){
        return (2*index+1);
    }

    public int getRightChild(Integer index){
        return (2*index+2);
    }

    public void insertKey(Integer key){
        if(size == capacity){
            return;
        }
        harr[size] = key;
        Integer parentKey = size-1;
        size++;

        if(parentKey > 0) {
            while (harr[getParent(parentKey)] > harr[parentKey] && parentKey != 0) {
                swap(parentKey, getParent(parentKey));
                parentKey = getParent(parentKey);
            }
        }
    }

    public void print(){
        for(int i = 0; i < size; i++){
            System.out.println(harr[i]);
        }
    }

    public void swap(Integer index, Integer parent){
        int temp = harr[index];
        harr[index] = harr[parent];
        System.out.println("indeex="+harr[index]);
        harr[parent] = temp;
        System.out.println("parent="+harr[parent]);
    }

}
