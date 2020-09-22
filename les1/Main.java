package les1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] ar1 = {"wiuc", "oceo", "eiuub3ic"};
        swap(ar1, 0, 1);
        List<String> list1 = new ArrayList<>(asArrayList(ar1));
        for (String s : list1) {
            System.out.println(s);
        }

        System.out.println();

        Integer[] ar2 = {1, 2, 3};
        swap(ar2, 0, 1);
        List<Integer> list2 = new ArrayList<>(asArrayList(ar2));
        for (Integer s : list2) {
            System.out.println(s);
        }

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());

        appleBox2.addFruit(new Apple());

        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        if(appleBox1.compareTo(orangeBox)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

        appleBox1.addAllFromBox(appleBox2);

        if(appleBox1.compareTo(orangeBox)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    public static <T> void swap(T[] arr, int index1, int index2) {
        if(index1 >= 0 && index1 < arr.length && index2 >= 0 && index2 < arr.length) {
            T t = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = t;
        }
    }

    public static <T> ArrayList<T> asArrayList(T[] arr) {
        ArrayList<T> list = new ArrayList<>();
        for(T t: arr) {
            list.add(t);
        }
        return list;
    }
}

