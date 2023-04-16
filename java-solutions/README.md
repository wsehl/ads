## MyList Interface

An interface for a generic list of elements, with the following methods:

1. `size()` : returns the number of elements in the list
2. `contains(Object item)` : returns `true` if the specified item is present in the list, `false` otherwise
3. `add(T item)` : adds the specified item to the end of the list
4. `add(T item, int index)` : adds the specified item to the list at the specified index, shifting the existing elements to the right
5. `remove(T item)` : removes the first occurrence of the specified item from the list, if it is present
6. `remove(int index)` : removes the item at the specified index from the list, shifting the remaining elements to the left
7. `clear()` : removes all elements from the list
8. `get(int index)` : returns the item at the specified index
9. `indexOf(Object item)` : returns the index of the first occurrence of the specified item in the list, or -1 if it is not present
10. `lastIndexOf(Object item)` : returns the index of the last occurrence of the specified item in the list, or -1 if it is not present
11. `sort()` : sorts the list according to the natural ordering of its elements

## MyArrayList Class

An implementation of `MyList` implemented as a dynamic array

## MyLinkedList Class

An implementation of `MyList` implemented as a doubly linked list 