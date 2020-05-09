package FactoryMethod.Concrete;

import FactoryMethod.Abstract.SensorFactory;
import Observer.PollutionSensor;
import Observer.Sensor;

public class PollutionSensorFactory extends SensorFactory {
    public PollutionSensorFactory(String name, double sensorValue) {
        super(name, sensorValue);
    }

    @Override
    public Sensor createSensor() {
        return new PollutionSensor(_name,_sensorValue);
    }
}
