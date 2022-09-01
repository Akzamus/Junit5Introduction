package org.example.JUnit5;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FruitsBasketTest {

    private final FruitsBasket basket = new FruitsBasket();
    private final Fruit apple = new Fruit("Apple", 120);
    private final Fruit orange = new Fruit("Orange",120);
    private final Fruit pear = new Fruit("Pear", 120);

    @BeforeEach
    void init(TestInfo info) {
        basket.add(apple);
        basket.add(orange);
        basket.add(pear);
        System.out.println("Method start: " + info.getTestMethod().get().getName());
    }

    @AfterEach
    void destroy(TestInfo info) {
        basket.removeAll();
        System.out.println("Method stop: " + info.getTestMethod().get().getName() + "\n");
    }

    @BeforeAll
    static void initAll(TestInfo info) {
        System.out.println("Test start: " + info.getDisplayName() + "\n");
    }

    @AfterAll
    static void destroyAll(TestInfo info) {
        System.out.println("Test stop: " + info.getDisplayName());
    }

    @Test
    void add() {
        basket.add(new Fruit("Banana", 200));
        assertEquals(4, basket.getSize(), "Adding one more fruit to the basket");
    }

    @Test
    void remove() {
        basket.remove(orange);
        assertEquals(2, basket.getSize(), "Removing a fruit from the basket");
    }

    @Test
    @DisplayName("When fruit does not exist in basket throw an NSE")
    void remove_TestForException() {
        assertThrows(NoSuchElementException.class,
                () -> basket.remove(new Fruit("Kiwi", 80)),
                "Removing a fruit from the basket");
    }

    @RepeatedTest(3)
    void remove_TestForTimeout() {
        assertTimeout(Duration.ofMillis(1),
                () -> basket.remove(apple),
                "Testing for productivity");
    }

    @Test
    void getSize() {
        assertEquals(3, basket.getSize(), "Checking basket's size");
    }

    @Test
    void removeAll() {
        basket.removeAll();
        assertEquals(0, basket.getSize(), "Removing all fruits from the basket");
    }

    @Test
    void getFruitByName_FruitExists() {
        assertEquals(apple, basket.getFruitByName("Apple"), "Getting a fruit by name");
    }

    @Test
    void getFruitByName_NotExists() {
        assertNull(basket.getFruitByName("Banana"), "Getting a fruit by name");
    }

    @Test
    void containsFruit() {
        assertTrue(basket.containsFruit(apple), "Checking the availability of fruit");
    }

    @Test
    void getFruitNames() {
        List<String> fruitNames = new ArrayList<>();
        Collections.addAll(fruitNames, "Apple", "Orange", "Pear");
        assertIterableEquals(fruitNames, basket.getFruitNames());
    }
}