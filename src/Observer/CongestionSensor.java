package Observer;

//Concrete Subject
public class CongestionSensor extends Sensor {

    public CongestionSensor(String name, double sensorValue) {
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
        if(sensorValue<10){
            System.out.println("\nValue => " + sensorValue +" "+getName()+" has been changes state Car speed below 10km/h value..\n");
            return true;
        }
        return false;
    }
}
