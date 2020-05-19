package Observer;

public class NoiseSensor extends Sensor {
    public NoiseSensor(String name, double sensorValue) {
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
        if(sensorValue>85){
            System.out.println("\nValue => " + sensorValue +" "+getName()+" has been changes state above 85dB value..\n");
            return  true;
        }
        return false;
    }
}
