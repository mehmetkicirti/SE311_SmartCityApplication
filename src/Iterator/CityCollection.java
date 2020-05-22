package Iterator;

import Composite.INeighborhood;

import java.util.ArrayList;
import java.util.List;

//Implements Aggregate Interface and purpose of  with createIterator  having list elements to send.
public class CityCollection implements ICityAggregate{
    private List<INeighborhood> _cityCollection;

    public CityCollection(){
        _cityCollection = new ArrayList<>();
    }
    public CityCollection(List<INeighborhood> collection){
        _cityCollection = collection;
    }

    @Override
    public ICityIterator createIterator() {
        return new CityIterator(this);
    }

    @Override
    public void addItem(INeighborhood item) {
        _cityCollection.add(item);
    }

    @Override
    public void removeItem(INeighborhood item) {
        _cityCollection.remove(item);
    }

    @Override
    public int getCount() {
        return _cityCollection.size();
    }

    @Override
    public INeighborhood getItem(int index) {
        return _cityCollection.get(index);
    }
}
