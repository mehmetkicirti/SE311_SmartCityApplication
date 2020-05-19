package Observer;


public class PollutionSensor extends Sensor {

    public PollutionSensor(String name, double sensorValue) {
        super(name, sensorValue);
    }

    @Override
    public void setSensorValue(double sensorValue) {
        this._sensorValue = sensorValue;
        if(checkStatus(sensorValue)){
            setIsFault(true);
            notifySubscribers();
        }
    }

    @Override
    protected boolean checkStatus(double sensorValue) {
        if(sensorValue>100){
            System.out.println("\nValue => " + sensorValue +" "+getName()+" has been changes state above 100 AQI value..\n");
            return true;
        }
        return false;
    }
}
