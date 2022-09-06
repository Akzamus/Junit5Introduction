package org.example.JUnit5;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestSequence {

    @Test
    @Order(1)
    void test1(TestInfo testInfo) {
        System.out.println("in " + testInfo.getDisplayName());
    }

    @Test
    @Order(2)
    void test2(TestInfo testInfo) {
        System.out.println("in " + testInfo.getDisplayName());
    }

    @Test
    @Order(3)
    void test3(TestInfo testInfo) {
        System.out.println("in " + testInfo.getDisplayName());
    }
}
