import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<Map.Entry<K, V>> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        root = put(root, key, value);
        size++;
    }

    private Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value);
        }
        if (key.compareTo(x.key) < 0) {
            x.left = put(x.left, key, value);
        } else if (key.compareTo(x.key) > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        return x;
    }

    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
        size--;
    }

    private Node delete(Node x, K key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    public int size() {
        return size;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new BSTIterator(root);
    }

    private class BSTIterator implements Iterator<Map.Entry<K, V>> {
        private Stack<Node> stack = new Stack<>();

        public BSTIterator(Node x) {
            pushLeft(x);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Map.Entry<K, V> next() {
            Node node = stack.pop();
            pushLeft(node.right);
            return new AbstractMap.SimpleEntry<>(node.key, node.value);
        }

        private void pushLeft(Node x) {
            while (x != null) {
                stack.push(x);
                x = x.left;
            }
        }
    }
}
