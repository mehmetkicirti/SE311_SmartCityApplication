package Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Sensor {
    private String _name;
    protected double _sensorValue;
    protected boolean _isFault;
    private List<ISubscriber> _subscribers;

    public Sensor(String name, double sensorValue){
        this._name = name;
        this._isFault = false;
        this._sensorValue = sensorValue;
        this._subscribers = new ArrayList<>();
    }
    public void attach(ISubscriber subscriber){
        _subscribers.add(subscriber);
    }

    public void detach(ISubscriber subscriber){
        _subscribers.remove(subscriber);
    }

    protected void notifySubscribers(){
        for(ISubscriber subscriber : _subscribers){
            subscriber.update(this);
        }
    }
    public boolean getIsFaultSensorState(){
        return _isFault;
    }
    public void setIsFaultSensor(boolean isFault){
        this._isFault = isFault;
    }
    public String getName(){
        return this._name;
    }
    public double getSensorValue(){
        return this._sensorValue;
    }
    public abstract void setSensorValue(double sensorValue);
    protected abstract boolean checkStatus(double sensorValue);

    @Override
    public String toString() {
        return "Name: "+getName() + "\nValue: "+getSensorValue() + "\nIsFault: "+getIsFaultSensorState()+"\n";
    }
}
