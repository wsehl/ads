/*
 * Implementation of a linked list in Java.
 */
public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T element;
        Node next;
        Node previous;

        public Node(T element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T element) {
        Node node = new Node(element);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = null;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current.element;
    }

    @Override
    public boolean remove(T element) {
        Node current = head;
        while (current != null) {
            if (current.element.equals(element)) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.previous = null;
                    }
                } else if (current == tail) {
                    tail = tail.previous;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object element) {
        Node current = head;
        while (current != null) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void add(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
            return;
        }
        Node node = new Node(element);
        Node current = null;
        if (index == 0) {
            current = head;
            head = node;
            head.next = current;
            current.previous = head;
        } else {
            if (index < size / 2) {
                current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
            } else {
                current = tail;
                for (int i = size - 1; i > index; i--) {
                    current = current.previous;
                }
            }
            node.next = current;
            node.previous = current.previous;
            current.previous.next = node;
            current.previous = node;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = null;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
        } else if (current == tail) {
            tail = tail.previous;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
        return current.element;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int indexOf(Object element) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.element.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        Node current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.element.equals(element)) {
                return index;
            }
            current = current.previous;
            index--;
        }
        return -1;
    }

    @Override
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head.next;
        while (current != null) {
            T temp = current.element;
            Node previous = current.previous;
            while (previous != null && ((Comparable<T>) previous.element).compareTo(temp) > 0) {
                previous.next.element = previous.element;
                previous = previous.previous;
            }
            if (previous == null) {
                head.element = temp;
            } else {
                previous.next.element = temp;
            }
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.element);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
