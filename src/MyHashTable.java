public class MyHashTable<K, V> {
    @SuppressWarnings("hiding")
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private HashNode<K, V>[] chainArray;
    private final int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashTable(int capacity) {
        this.capacity = capacity;
        chainArray = new HashNode[capacity];
    }

    public MyHashTable() {
        this(11);
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    public void put(K key, V value) {
        int h = hash(key);
        HashNode<K, V> node = new HashNode<>(key, value);
        node.next = chainArray[h];
        chainArray[h] = node;
        size++;
    }

    public V get(K key) {
        int h = hash(key);
        for (HashNode<K, V> node = chainArray[h]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int h = hash(key);
        HashNode<K, V> node = chainArray[h];
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            chainArray[h] = node.next;
            size--;
            return node.value;
        }
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                HashNode<K, V> removedNode = node.next;
                node.next = node.next.next;
                size--;
                return removedNode.value;
            }
            node = node.next;
        }
        return null;
    }

    public boolean contains(K key) {
        int h = hash(key);
        for (HashNode<K, V> node = chainArray[h]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (HashNode<K, V> node : chainArray) {
            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < capacity; i++) {
            int count = 0;
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                count++;
                node = node.next;
            }
            result += "bucket[" + i + "] => " + count + " elements\n";
        }
        return result;
    }
}
