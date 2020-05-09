package Observer;

public class TemperatureSensor extends Sensor {
    public TemperatureSensor(String name, double sensorValue) {
        super(name, sensorValue);
    }

    @Override
    public void setSensorValue(double sensorValue) {
        this._sensorValue = sensorValue;
        if(checkStatus(sensorValue)){
            setIsFaultSensor(true);
            notifySubscribers();
        }
    }

    @Override
    protected boolean checkStatus(double sensorValue) {
        if(sensorValue<0){
            System.out.println("\nValue => " + sensorValue +" "+getName()+" as important state changes temperature below 0 degrees");
            return true;
        }
        return false;
    }
}
