package lists;

public class HashMap{

    private HashNode[] hashMap;
    private int size;

    public HashMap(int size){
        hashMap = new HashNode[size];
        this.size = size;
    }

    public void add(String value){
        Key k = new Key(value);
        HashNode hNode = new HashNode(k.hashCode(), value, k, null);
    }


    private class HashNode{

        private int hash;
        private String value;
        private Key key;
        private HashNode next;

        public HashNode(int hash, String value, Key key, HashNode next){
            this.hash = hash;
            this.value = value;
            this.key = key;
            this.next = next;
        }

        public int getHash(HashNode hNode){
            return hNode.hash;
        }

        public String getValue(HashNode hNode){
            return hNode.value;
        }

        public Key getKey(HashNode hNode){
            return hNode.key;
        }

        public HashNode getNext(HashNode hNode){
            return hNode.next;
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
