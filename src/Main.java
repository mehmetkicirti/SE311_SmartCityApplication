import Command.Engineer;
import Command.ICommand;
import Command.ResetSensorsCommand;
import Composite.Apartment;
import Composite.NeighborhoodComposite;
import FactoryMethod.SensorCreator;
import FactoryMethod.Utils.SensorType;
import Iterator.CityCollection;
import Observer.Citizen;
import Observer.Sensor;
import Singleton.CityWideMonitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CityWideMonitor monitor = CityWideMonitor.getCityWideMonitor();
        CityCollection collection = monitor.getCityCollection();

        List<Sensor> sensors = new ArrayList<>();
        Sensor pollutionSensor = SensorCreator.createSensor(SensorType.Pollution,"Pollution Sensor",12);
        Sensor temperatureSensor = SensorCreator.createSensor(SensorType.Temperature,"Temperature Sensor",22);
        Sensor congestionSensor = SensorCreator.createSensor(SensorType.Congestion,"Congestion Sensor",32);
        Sensor noiseSensor = SensorCreator.createSensor(SensorType.Noise,"Noise Sensor",25);
        sensors.add(pollutionSensor);
        sensors.add(temperatureSensor);
        sensors.add(congestionSensor);
        sensors.add(noiseSensor);

        NeighborhoodComposite eylulMah = new NeighborhoodComposite("Eylül Neighborhood");
        NeighborhoodComposite ulastirmaStreet = new NeighborhoodComposite("Ulastirma Street");
        eylulMah.add(ulastirmaStreet);
        ulastirmaStreet.add(new Apartment("Tunay Apartment",sensors));
        collection.addItem(eylulMah);

        monitor.showStatus();

        Citizen mehmet = new Citizen("Mehmet Aydın","KICIRTI");
        Citizen ozan = new Citizen("Mustafa Ozan","GÜNEY");
        Citizen merve = new Citizen("Merve","TELLİ");
        //mehmet subscribed to sensors if there is any modified into sensor, it will be send notified message
        mehmet.setSensor(sensors);
        ozan.setSensor(sensors);
        merve.setSensor(sensors);

        pollutionSensor.attach(mehmet);
        pollutionSensor.attach(ozan);
        pollutionSensor.setSensorValue(101);


        monitor.showStatus();

        ICommand resetCommand = new ResetSensorsCommand(sensors);
        Engineer engineer = new Engineer(resetCommand);
        engineer.resetSensors();

        monitor.showStatus();
    }
}
