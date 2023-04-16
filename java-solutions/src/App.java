public class App {
    public static void main(String[] args) throws Exception {
        MyList<String> list = new MyArrayList<>();
        MyList<Number> numberList = new MyArrayList<>();

        list.add("Hello");
        list.add("World");
        list.add("!");

        System.out.println(list.get(0));

        System.out.println(list.lastIndexOf("World"));

        System.out.println(list.contains("output"));

        numberList.add(3);
        numberList.add(1);
        numberList.add(2);

        numberList.sort();

        System.out.println(numberList.get(0));

        numberList.remove(0);

        System.out.println(numberList.get(0));

        numberList.clear();

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.add(24);
        linkedList.add(33);
        linkedList.add(10);
        linkedList.add(45);

        System.out.println(linkedList.get(2)); // should be 10

        System.out.println(linkedList.size()); // should be 4

        linkedList.add(63);
        System.out.println(linkedList); // should be [24, 33, 10, 45, 63]

        linkedList.remove(3);
        System.out.println(linkedList);

        System.out.println(linkedList.contains(45)); // false

        System.out.println(linkedList.indexOf(10)); // should be 2
        System.out.println(linkedList.indexOf(100)); // should be -1

        linkedList.sort();
        System.out.println(linkedList); // [10, 24, 33, 63]

        linkedList.clear();
        System.out.println(linkedList); // []
    }
}
