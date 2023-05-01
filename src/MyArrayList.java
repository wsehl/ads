/**
 * A dynamic array implementation of the List interface.
 *
 * @param <T> the type of elements in this list
 */
public class MyArrayList<T> implements MyList<T> {
    private Object[] data;
    private int size;

    private int GROW_COEFFICIENT = 2;

    public MyArrayList(int initialCapacity) {
        data = new Object[initialCapacity];
    }

    public MyArrayList() {
        this(10);
    }

    private void grow() {
        Object[] temp = new Object[data.length * GROW_COEFFICIENT];
        System.arraycopy(data, 0, temp, 0, size);
        data = temp;
    }

    @Override
    public void add(T element) {
        if (size == data.length) {
            grow();
        }
        data[size] = element;
        size++;
    }

    @Override
    public T get(int index) {
        return (T) data[index];
    }

    @Override
    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T item, int index) {
        if (size == data.length) {
            grow();
        }

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        // shift elements right
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = item;
        size++;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        T removed = (T) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;

        return removed;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // Sort elements in ascending order with the bubble sort algorithm
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) data[j]).compareTo((T) data[j + 1]) > 0) {
                    T temp = (T) data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}
