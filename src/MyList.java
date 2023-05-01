public interface MyList<T> {
    int size();
    boolean contains(Object item);
    void add(T item);
    void add( T item, int index);
    boolean remove(T item);
    T remove(int index);
    void clear();
    T get(int index);
    int indexOf(Object item);
    int lastIndexOf(Object item);
    void sort();
}