package Iterator;

import Composite.INeighborhood;

//Iterator => Loads the responsibilities of the criteria, such as how the object should move, into the Iterator object
public interface ICityIterator {
    void first();
    boolean isContinue();
    void next();
    INeighborhood currentItem();
}
