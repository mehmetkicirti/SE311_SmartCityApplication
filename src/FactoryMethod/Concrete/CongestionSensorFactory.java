package FactoryMethod.Concrete;

import FactoryMethod.Abstract.SensorFactory;
import Observer.CongestionSensor;
import Observer.Sensor;

public class CongestionSensorFactory extends SensorFactory {

    public CongestionSensorFactory(String name, double sensorValue) {
        super(name, sensorValue);
    }

    @Override
    public Sensor createSensor() {
        return new CongestionSensor(_name,_sensorValue);
    }
}
