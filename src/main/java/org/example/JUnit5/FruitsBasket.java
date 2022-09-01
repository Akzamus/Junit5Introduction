package org.example.JUnit5;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class FruitsBasket {

    private final List<Fruit> basket = new ArrayList<>();

    public void add(Fruit fruit) {
        basket.add(fruit);
    }

    public void remove(Fruit fruit) {
        if(!basket.contains(fruit))
            throw new NoSuchElementException();
        basket.remove(fruit);
    }

    public int getSize() {
        return basket.size();
    }

    public void removeAll() {
        basket.clear();
    }

    public Fruit getFruitByName(String name) {
        for (Fruit fruit : basket) {
            if (fruit.getName().equalsIgnoreCase(name))
                return fruit;
        }
        return null;
    }

    public boolean containsFruit (Fruit fruit) {
        return basket.contains(fruit);
    }

    public List<String> getFruitNames() {
        return basket.stream().map(Fruit::getName).collect(Collectors.toList());
    }
}
