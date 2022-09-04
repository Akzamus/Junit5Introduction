package org.example.JUnit5.PersonValidatorTest;

import org.example.JUnit5.Person;
import org.example.JUnit5.PersonValidator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing PersonValidator")
class PersonValidatorTest {

    @Nested
    @DisplayName("When using valid data")
    @ExtendWith(ValidPersonParameterResolver.class)
    public class ValidData{

        @RepeatedTest(10)
        @DisplayName("All first names valid")
        public void validateFirstName(Person person) {
            Assertions.assertTrue(PersonValidator.validateFirstName(person));
        }
    }

    @Nested
    @DisplayName("When using invalid data")
    @ExtendWith(InvalidPersonParameterResolver.class)
    public class InvalidData{

        @RepeatedTest(10)
        @DisplayName("All first names invalid")
        public void validateFirstName(Person person) {
            assertTrue(PersonValidator.validateFirstName(person));
        }
    }
}