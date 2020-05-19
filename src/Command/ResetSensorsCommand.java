package Command;

import Observer.Sensor;

import java.util.List;

public class ResetSensorsCommand implements ICommand{
    private List<Sensor> _sensors;

    public ResetSensorsCommand(List<Sensor> sensors){
        _sensors = sensors;
    }
    @Override
    public void execute() {
        System.out.println("Sensors are resetting now by engineer..");
        for(Sensor sensor :_sensors){
            sensor.setSensorValue(15);
            sensor.setIsFault(false);
        }
        System.out.println("Sensors were fixed by engineer..\n");
    }
}
