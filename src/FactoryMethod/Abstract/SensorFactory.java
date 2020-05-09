package FactoryMethod.Abstract;

import Observer.Sensor;

import java.util.ArrayList;
import java.util.List;

public abstract class SensorFactory {
    protected String _name;
    protected double _sensorValue;

    public SensorFactory(String name, double sensorValue){
        this._name = name;
        this._sensorValue = sensorValue;
    }

    public abstract Sensor createSensor();
}
