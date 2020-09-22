package les1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitList;

    public Box() {
        fruitList = new ArrayList<>();
    }

    float getWeight() {
        float weight = 0;
        for (T t : fruitList) {
            weight += t.getWeight();
        }
        return weight;
    }

    public ArrayList<T> getFruitList() {
        return fruitList;
    }

    void addFruit(T fruit) {
        fruitList.add(fruit);
    }

    void addAllFromBox(Box<T> box) {
        for(T t: box.getFruitList()) {
            this.fruitList.add(t);
        }
    }

    boolean compareTo(Box<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }
}
