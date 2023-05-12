import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        BST<Integer, Integer> bst = new BST<>();

        bst.put(5, 13);
        bst.put(2, 3);
        bst.put(100, 2);
        bst.put(4, 2);
        bst.put(1, 96);
        bst.put(3, 11);

        for (Map.Entry<Integer, Integer> entry : bst) {
            System.out.println("key is " + entry.getKey() + " and value is " + entry.getValue());
        }

    }
}
