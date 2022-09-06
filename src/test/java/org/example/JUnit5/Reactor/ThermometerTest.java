package org.example.JUnit5.Reactor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ThermometerTest {

    @InjectMocks
    private Thermometer thermometer;

    @Mock
    private Sensor sensor;

    @Test
    void testWorkingSensor() {
        thermometer.setTemperature(250.0);
        when(sensor.isBlocked()).thenReturn(false);
        assertEquals(sensor, thermometer.getSensor());
        assertEquals(250.0, thermometer.getTemperature(), 0.1);
        verify(sensor, times(1)).isBlocked();
    }

    @Test
    void testBlockedSensor() {
        thermometer.setTemperature(250.0);
        when(sensor.isBlocked()).thenReturn(true);
        assertEquals(sensor, thermometer.getSensor());
        assertThrows(RuntimeException.class, () -> thermometer.getTemperature());
        verify(sensor, times(1)).isBlocked();
    }

}