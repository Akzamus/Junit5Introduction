package org.example.JUnit5.Reactor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReactorCoolingSystemTest {

    @InjectMocks
    private ReactorCoolingSystem reactorCoolingSystem;

    @Mock
    private Thermometer thermometer;

    @Test
    void testReactorCoolingSystemON() {
        when(thermometer.getTemperature()).thenReturn(250.0);
        reactorCoolingSystem.setTemperatureThreshold(240.0);
        reactorCoolingSystem.checkReactorCoolingSystem();
        assertTrue(reactorCoolingSystem.isOn());
        verify(thermometer, times(1)).getTemperature();
    }

    @Test
    void testReactorCoolingSystemOFF() {
        when(thermometer.getTemperature()).thenReturn(230.0);
        reactorCoolingSystem.setTemperatureThreshold(240.0);
        reactorCoolingSystem.checkReactorCoolingSystem();
        assertFalse(reactorCoolingSystem.isOn());
        verify(thermometer, times(1)).getTemperature();
    }
}