package lists;

public class HashMap{

    private HashNode[] hashMap;
    private int size;

    public HashMap(int size){
        hashMap = new HashNode[size];
        this.size = size;
    }

    public void add(String key, int value){
        Key k = new Key(key);
        HashNode hNode = new HashNode(k.hashCode(), k, value, null);
        int index = k.hashCode() & size -1;
        if(isFull()) {
            reSize();
        }
        if (hashMap[index] == null) {
            hashMap[index] = hNode;
        } else {
            addNode(hashMap[index], hNode);
        }
    }

    public void addNode(HashNode hNode, HashNode nodeToAdd){
        if(hNode.next == null){
            hNode.next = nodeToAdd;
        } else {
            addNode(hNode.next, nodeToAdd);
        }
    }

    public boolean isFull(){
        int count = 0;
        for(int i = 0; i < hashMap.length; i++){
            if(hashMap[i] != null) {
                count++;
            }
        }
        if(count == size){
            return true;
        }
        return false;
    }

    public boolean contains(String keyToSearch){
        Key k = new Key(keyToSearch);
        int indexToSearch = k.hashCode() & size-1;
        if(hashMap[indexToSearch] == null) {
            return false;
        }
        HashNode h = hashMap[indexToSearch];
        while(h != null){
            if(h.getKey().key.equals(keyToSearch)) return true;
            h = h.next;
        }
        return false;
    }

    public boolean delete(String keyValue){
        if(contains(keyValue)){
            Key k = new Key(keyValue);
            int index = k.hashCode() & size -1;
            if(hashMap[index].getKey().key.equals(keyValue)){
                hashMap[index] = null;
                return true;
            } else {
                return delete(hashMap[index], null, keyValue);
            }
        }
        return false;
    }

    public boolean delete(HashNode hashNode, HashNode previous, String keyValue){
        if(hashNode.getKey().key.equals(keyValue)){
            previous.next = hashNode.next;
            return true;
        } else{
            delete(hashNode.next, hashNode, keyValue);
        }
        return false;
    }

    public void reSize(){
        if(isFull()){
            HashNode[] oldMap = new HashNode[size];
            for(int i = 0; i < oldMap.length; i++){
                oldMap[i] = hashMap[i];
            }
            size = (int)(size * 1.5);
            hashMap = new HashNode[size];
            for(int i = 0; i < oldMap.length; i++){
                HashNode node = oldMap[i];
                while(node != null){
                    int index = node.hashCode() & size-1;
                    hashMap[index] = node;
                    node = node.next;
                }
            }
        }
    }

    private class HashNode{

        private int hash;
        private Key key;
        private int value;
        private HashNode next;

        public HashNode(int hash, Key key, int value, HashNode next){
            this.hash = hash;
            this.value = value;
            this.key = key;
            this.next = next;
        }

        public int getHash(){
            return this.hash;
        }

        public int getValue(){
            return this.value;
        }

        public Key getKey(){
            return this.key;
        }

        public HashNode getNext(){
            return this.next;
        }
    }

    private class Key {

        private String key;

        public Key(String key) {
            this.key = key;
        }

        @Override
        public int hashCode() {
            return (int)key.charAt(0);
        }

        @Override
        public boolean equals(Object obj) {
            return key.equals((String)obj);
        }
    }

}
