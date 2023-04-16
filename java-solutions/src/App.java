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

        numberList.remove(2);

        try {
            System.out.println(numberList.get(1));
        } catch (Exception e) {
            System.out.println("Index out of bounds");
        }

        numberList.clear();
    }
}
