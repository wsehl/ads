public class MyHashTable<K, V> {
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
    private int M = 11; // default number of chains
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }

    private int hash(K key) {
        return key.hashCode() % M;
    }

    public void put(K key, V value) {
        int h = hash(key);
        HashNode<K, V> node = chainArray[h];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[h];
        chainArray[h] = newNode;
        size++;
    }

    public V get(K key) {
        int h = hash(key);
        HashNode<K, V> node = chainArray[h];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
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
        HashNode<K, V> node = chainArray[h];
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
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

        for (int i = 0; i < M; i++) {
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
