package Iterator;

import Composite.INeighborhood;

//Aggregate => Client use and also iterastion and also
//It is the object that fulfills the responsibility of iteration
// called as a collection.
public interface ICityAggregate {
    ICityIterator createIterator();
    void addItem(INeighborhood item);
    void removeItem(INeighborhood item);
    int getCount();
    INeighborhood getItem(int index);
}
