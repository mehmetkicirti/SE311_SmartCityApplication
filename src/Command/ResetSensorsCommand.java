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
        for(Sensor sensor :_sensors){
            sensor.setSensorValue(15);
            sensor.setIsFaultSensor(false);
        }
    }
}
