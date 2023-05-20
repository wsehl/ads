public class Sort<T extends Comparable<T>> {
    // Merge Sort Part
    public void mergeSort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(T[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);

            merge(arr, start, end, middle);
        }
    }

    private void merge(T[] arr, int start, int end, int middle) {
        Object[] a = new Object[middle - start + 1];
        Object[] b = new Object[end - middle];

        // take a copy of left half
        for (int j = 0; j < a.length; j++) {
            a[j] = arr[start + j];
        }

        // take a copy of right half
        for (int j = 0; j < b.length; j++) {
            b[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0, k = start;
        while (i < a.length && j < b.length) {
            if (((T) a[i]).compareTo((T) b[j]) <= 0) {
                arr[k++] = (T) a[i++];
            } else {
                arr[k++] = (T) b[j++];
            }
        }

        while (i < a.length) {
            arr[k++] = (T) a[i++];
        }

        while (j < b.length) {
            arr[k++] = (T) b[j++];
        }
    }

    // Quick Sort Part
    public void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(T[] arr, int start, int end) {
        if (start < end) {
            int pi = partition(arr, start, end);
            quickSort(arr, start, pi - 1);
            quickSort(arr, pi + 1, end);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(T[] arr, int start, int end) {
        T pivot = arr[end]; // select pivot point
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, end);

        return i + 1;
    }
}
