package Iterator;

import Composite.INeighborhood;

//ConcreteIterator and implemented by ICityIterator interface aimed that each object to get values.
public class CityIterator implements ICityIterator{
    private ICityAggregate _collection;
    private int currentIndex = 0;

    public CityIterator(ICityAggregate collection){
        _collection = collection;
    }

    @Override
    public void first() {
        this.currentIndex = 0;
    }

    @Override
    public boolean isContinue() {
        return currentIndex<_collection.getCount();
    }

    @Override
    public void next() {
        this.currentIndex++;
    }

    @Override
    public INeighborhood currentItem() {
        return _collection.getItem(currentIndex);
    }
}
