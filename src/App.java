import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(10);
        Random rnd = new Random();

        for (int i = 0; i < 10_000; i++) {
            MyTestingClass key = new MyTestingClass(i);

            table.put(key, new Student("Oh Dae-su", rnd.nextInt(17, 23)));
        }

        System.out.println(table);
    }
}
