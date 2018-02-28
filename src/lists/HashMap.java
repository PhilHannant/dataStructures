package lists;

public class HashMap{

    private HashNode[] hashMap;


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
    }

    private class Key
    {
        String key;
        Key(String key)
        {
            this.key = key;
        }

        @Override
        public int hashCode()
        {
            return (int)key.charAt(0);
        }

        @Override
        public boolean equals(Object obj)
        {
            return key.equals((String)obj);
        }
    }

}
