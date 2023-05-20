import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int N = 100_000;
        boolean debug = false;

        Sort<Integer> mySort = new Sort<Integer>();

        Random random = new Random();

        Integer[] arr = new Integer[N];

        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt();

        long start = System.currentTimeMillis();

        mySort.mergeSort(arr);

        long end = System.currentTimeMillis();

        System.out.println("merge: Time taken: " + (end - start) + "ms");

        if (debug)
            for (Integer i : arr) {
                System.out.println(i);
            }

        Integer[] arr2 = new Integer[N];

        for (int i = 0; i < arr2.length; i++)
            arr2[i] = random.nextInt();

        start = System.currentTimeMillis();

        mySort.quickSort(arr2);

        end = System.currentTimeMillis();

        System.out.println("quick: Time taken: " + (end - start) + "ms");

        if (debug)
            for (Integer i : arr2) {
                System.out.println(i);
            }
    }
}
