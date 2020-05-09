package Composite;

import Observer.Sensor;

import java.util.List;

//Another leaf object
public class Pole implements INeighborhood,ISensorDetail{
    private String _name;
    private List<Sensor> _poleSensors;
    public Pole(String name,List<Sensor> poleSensor){
        _name =name;
        _poleSensors = poleSensor;
    }

    @Override
    public void display(int depth) {
        for(int i = 0;i <= depth;i++) 	System.out.print("-");
        System.out.println("Pole Name : " + getName());
        System.out.println("Sensors Detail => ");
        for(Sensor sensor : _poleSensors){
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
        for(Sensor sensor : _poleSensors){
            if (!sensor.getIsFaultSensorState()) continue;
            total+=1;
        }
        return total;
    }

    @Override
    public List<Sensor> getSensors() {
        return _poleSensors;
    }
}
