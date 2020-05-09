package FactoryMethod.Concrete;

import FactoryMethod.Abstract.SensorFactory;
import Observer.Sensor;
import Observer.TemperatureSensor;

public class TemperatureSensorFactory extends SensorFactory {

    public TemperatureSensorFactory(String name, double sensorValue) {
        super(name, sensorValue);
    }

    @Override
    public Sensor createSensor() {
        return new TemperatureSensor(_name,_sensorValue);
    }
}
