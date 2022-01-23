package task3;

import task3.fruit.Fruits;

import java.util.ArrayList;
import java.util.List;

public class Box<F extends Fruits> {

    private final List<F> source = new ArrayList<>();

    // return immutable List
    public List<F> getSource() {
        return new ArrayList<>(source);
    }

    public void add(F item) {
        source.add(item);
    }

    public void remove(F item) {
        source.remove(item);
    }

    public float getWeight() {
        float weight = 0.0F;

        for (F f : source) {
            weight += f.getWeight();
        }

        return weight;
    }

    public boolean compare(Box<?> compared) {
        return compared != null && Math.abs(getWeight() - compared.getWeight()) < 0.0001;
    }

    public boolean pourInto(Box<F> destination) {

        for (F f : getSource()) {
            remove(f);
            destination.add(f);
        }

        return true;
    }
}
