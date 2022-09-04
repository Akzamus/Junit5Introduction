package org.example.JUnit5.ParameterResolver;

import org.example.JUnit5.Thing;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ThingParameterResolver.class)
class ThingTest {

    @Test
    void answer(Thing thing) {
        assertEquals(42, thing.answer());
    }
}