package Observer;

import java.util.ArrayList;
import java.util.List;

//Concrete Observer
public class Citizen implements ISubscriber {
    private String _name;
    private String _surname;
    private List<Sensor> _sensors;

    public Citizen(String name,String surname){
        this._name = name;
        this._surname = surname;
        _sensors = new ArrayList<>();
    }

    public List<Sensor> getSensors(){
        return _sensors;
    }

    public void setSensor(List<Sensor> sensors){
        this._sensors = sensors;
    }

    public String getName(){
        return _name;
    }

    public String getSurname(){
        return _surname;
    }

    public void setSurname(String surname){
        this._surname = surname;
    }

    public void setName(String name){
        this._name = name;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname();
    }

    public int getUpdateSensorIndex(Sensor sensor){
        return getSensors().indexOf(sensor);
    }
    @Override
    public void update(Sensor sensor) {
        int indexOfUpdateSensor = getUpdateSensorIndex(sensor);
        getSensors().set(indexOfUpdateSensor,sensor);

        System.out.println(
                "Hi Dear, " + toString() + "\nThere is a notify to " + sensor.getName() + "\nIf you look maybe great to you " +
                        "\nSensor Value => " + sensor.getSensorValue() + "\n"
        );
    }
}
