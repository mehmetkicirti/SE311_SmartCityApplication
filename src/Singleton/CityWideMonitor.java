package Singleton;

import Iterator.CityCollection;
import Iterator.ICityIterator;


public class CityWideMonitor {
    private static CityWideMonitor _cityWideMonitor;
    private CityCollection _cityCollection;

    private CityWideMonitor(){
        _cityCollection = new CityCollection();
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
