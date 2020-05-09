package FactoryMethod.Concrete;

import FactoryMethod.Abstract.SensorFactory;
import Observer.NoiseSensor;
import Observer.Sensor;

public class NoiseSensorFactory extends SensorFactory {

    public NoiseSensorFactory(String name, double sensorValue) {
        super(name, sensorValue);
    }

    @Override
    public Sensor createSensor() {
        return new NoiseSensor(_name,_sensorValue);
    }
}
