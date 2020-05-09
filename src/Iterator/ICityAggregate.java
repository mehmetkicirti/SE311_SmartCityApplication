package Iterator;

import Composite.INeighborhood;

//Aggregate => Istemci tarafı bunu kullanmakta iterasyon sorumlulugunu yerine getiren nesnedir collection da denir
public interface ICityAggregate {
    ICityIterator createIterator();
    void addItem(INeighborhood item);
    void removeItem(INeighborhood item);
    int getCount();
    INeighborhood getItem(int index);
}
