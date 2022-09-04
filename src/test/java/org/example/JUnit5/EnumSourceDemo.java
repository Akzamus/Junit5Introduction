package org.example.JUnit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.Assert.assertNotNull;

class EnumSourceDemo {

    @DisplayName("Passing enum values to the test method")
    @ParameterizedTest(name = "{index} => pet = ''{0}''")
    @EnumSource(value = Pet.class, names = {"DOG", "CAT"})
    void enumValuesFromNonNullity(Pet pet) {
        assertNotNull(pet);
    }
}
