package Singleton;

import Composite.Apartment;
import Composite.INeighborhood;
import Composite.NeighborhoodComposite;
import Composite.Pole;
import FactoryMethod.SensorCreator;
import FactoryMethod.Utils.SensorType;
import Iterator.CityCollection;
import Iterator.ICityIterator;


public class CityWideMonitor {
    private static CityWideMonitor _cityWideMonitor;
    private CityCollection _cityCollection;

    private CityWideMonitor(){
        _cityCollection = new CityCollection();
        //dummyCreateCityCollection();
    }

    public static CityWideMonitor getCityWideMonitor(){
        if(_cityWideMonitor == null){
            _cityWideMonitor = new CityWideMonitor();
        }
        return _cityWideMonitor;
    }
    public CityCollection getCityCollection(){
        return _cityCollection;
    }


/*

    private List<Sensor> dummyCreateSensorsApartment(){
        ArrayList<Sensor> apartmentSensors = new ArrayList<>();
        apartmentSensors.add(SensorCreator.createSensor(SensorType.Pollution,"Pollution Sensor",12));
        apartmentSensors.add(SensorCreator.createSensor(SensorType.Congestion,"Congestion Sensor",22));
        apartmentSensors.add(SensorCreator.createSensor(SensorType.Noise,"Noise Sensor",23));
        apartmentSensors.add(SensorCreator.createSensor(SensorType.Temperature,"Temperature Sensor",25));
        return apartmentSensors;
    }

    private List<Sensor> dummyCreateSensorsPole(){
        ArrayList<Sensor> poleSensors = new ArrayList<>();
        poleSensors.add(SensorCreator.createSensor(SensorType.Pollution,"Pollution Sensor",12));
        poleSensors.add(SensorCreator.createSensor(SensorType.Congestion,"Congestion Sensor",22));
        poleSensors.add(SensorCreator.createSensor(SensorType.Noise,"Noise Sensor",23));
        poleSensors.add(SensorCreator.createSensor(SensorType.Temperature,"Temperature Sensor",25));
        return poleSensors;
    }

    private void dummyCreateCityCollection(){
        NeighborhoodComposite eylulMah = new NeighborhoodComposite("Eylül Neighborhood");
        NeighborhoodComposite ulastirmaStreet = new NeighborhoodComposite("Ulastirma Street");
        eylulMah.add(ulastirmaStreet);
        ulastirmaStreet.add(new Apartment("Tunay Apartment",dummyCreateSensorsApartment()));
        ulastirmaStreet.add(new Pole("Tunay Apartment belonging the Pole",dummyCreateSensorsPole()));
        _cityCollection.addItem(eylulMah);
    }
 */
    public void addNeighborhood(INeighborhood neighborhood){
        _cityCollection.addItem(neighborhood);
    }

    public int getMalfuctioningSensorsNumber(){
        int total = 0;
        ICityIterator iterator = _cityCollection.createIterator();
        for(iterator.first();iterator.isContinue();iterator.next()){
            total+=iterator.currentItem().getTotalIsFaultSensors();
        }
        return total;
    }

    public void showStatus(){
        ICityIterator iterator = _cityCollection.createIterator();
        for(iterator.first();iterator.isContinue();iterator.next()){
            iterator.currentItem().display(1);
        }
        System.out.println("Total Malfunctioning Sensors => "+getMalfuctioningSensorsNumber()+"\n");
    }
}
