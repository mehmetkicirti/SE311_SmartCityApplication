package Composite;

import Observer.*;

import java.util.List;

//Leaf object
public class Apartment implements INeighborhood{
    private String _name;
    private List<Sensor> _apartmentSensors;

    public Apartment(String name, List<Sensor> apartmentSensors){
        this._apartmentSensors = apartmentSensors;
        this._name =name;
    }

    @Override
    public void display(int depth) {
        for(int i = 0;i <= depth;i++) 	System.out.print("-");
        System.out.println("Apartment Name : " + getName());
        System.out.println("Sensors Detail => ");
        for(Sensor sensor : _apartmentSensors){
            System.out.println(sensor.toString());
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public int getTotalIsFaultSensors() {
        int total = 0;
        for(Sensor sensor : _apartmentSensors){
            if (!sensor.getIsFault()) continue;
            total+=1;
        }
        return total;
    }
    public List<Sensor> getSensors() {
        return _apartmentSensors;
    }

    public void setSensors(List<Sensor> sensors){
        this._apartmentSensors = sensors;
    }
}
