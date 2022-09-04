package org.example.JUnit5.PersonValidatorTest;

import org.example.JUnit5.Person;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.Random;

public class ValidPersonParameterResolver implements ParameterResolver {

    public static final Person[] VALID_PERSONS = {
            new Person().setId(1L).setFirstName("Masha").setLastName("Ivanova"),
            new Person().setId(2L).setFirstName("Kolya").setLastName("Petrov"),
            new Person().setId(3L).setFirstName("Dasha").setLastName("Sidorova"),
            new Person().setId(4L).setFirstName("Sasha").setLastName("Kuznetsov"),
            new Person().setId(5L).setFirstName("Pasha").setLastName("Korolyov"),
            new Person().setId(6L).setFirstName("Natasha").setLastName("Rostova")
    };

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == Person.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return VALID_PERSONS[new Random().nextInt(VALID_PERSONS.length)];
    }
}
