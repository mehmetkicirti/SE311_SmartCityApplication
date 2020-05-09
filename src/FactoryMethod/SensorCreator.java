package FactoryMethod;

import FactoryMethod.Concrete.CongestionSensorFactory;
import FactoryMethod.Concrete.NoiseSensorFactory;
import FactoryMethod.Concrete.PollutionSensorFactory;
import FactoryMethod.Concrete.TemperatureSensorFactory;
import FactoryMethod.Utils.SensorType;
import Observer.Sensor;

//Client => is provided which subclasses created without unknown client
public class SensorCreator {
    public static Sensor createSensor(SensorType sensorType, String name, double sensorValue){
        switch (sensorType){
            case Congestion:
                return new CongestionSensorFactory(name,sensorValue).createSensor();
            case Temperature:
                return new TemperatureSensorFactory(name,sensorValue).createSensor();
            case Pollution:
                return new PollutionSensorFactory(name,sensorValue).createSensor();
            case Noise:
                return new NoiseSensorFactory(name,sensorValue).createSensor();
            default:
                throw new UnsupportedOperationException("Does not supported for now");
        }
    }
}
