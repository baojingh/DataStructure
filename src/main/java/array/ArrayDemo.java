package array;

public class ArrayDemo {


    public static void main(String[] args) {
        StaticArray arr = new StaticArray(10);
        arr.insert(0, 5);
        arr.insert(1, 3);
        arr.insert(2, 6);
        arr.insert(9, 9);
        arr.printAll();
        arr.delete(2);
        arr.printAll();
    }
}
