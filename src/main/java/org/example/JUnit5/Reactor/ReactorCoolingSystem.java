package org.example.JUnit5.Reactor;

public class ReactorCoolingSystem {

    private Thermometer thermometer;
    private double temperatureThreshold;
    private boolean on;

    public ReactorCoolingSystem() {
        this.on = false;
    }

    public void checkReactorCoolingSystem() {
        this.on = (thermometer.getTemperature() >= temperatureThreshold);
    }

    public boolean isOn() {
        return on;
    }

    public void setThermometer(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    public void setTemperatureThreshold(double temperatureThreshold) {
        this.temperatureThreshold = temperatureThreshold;
    }

    public Thermometer getThermometer() {
        return thermometer;
    }

    public double getTemperatureThreshold() {
        return temperatureThreshold;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
