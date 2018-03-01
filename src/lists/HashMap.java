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
        if(!isFull()) {
            if (hashMap[index] != null) {
                hashMap[index] = hNode;
            } else {
                hashMap[index].next = hNode;
            }
        }
    }

    public boolean isFull(){
        for(int i = 0; i < hashMap.length; i++){
            if(hashMap[i] == null) return false;
        }
        return true;
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
