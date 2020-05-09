package Composite;

import Iterator.CityCollection;
import Iterator.ICityAggregate;
import Iterator.ICityIterator;

//Composite Object implements INeighborhood also keeping leaf objects into list
public class NeighborhoodComposite implements INeighborhood{
    private ICityAggregate _neighborhoods;
    private String _name;

    public NeighborhoodComposite(String name){
        _neighborhoods = new CityCollection();
        _name = name;
    }

    public void add(INeighborhood neighborhood){
        _neighborhoods.addItem(neighborhood);
    }

    public void remove(INeighborhood neighborhood){
        _neighborhoods.removeItem(neighborhood);
    }

    @Override
    public void display(int depth) {
        for(int i = 1;i <= depth;i++) System.out.print("-");
        System.out.println( "+ "+getName());

        ICityIterator iterator = _neighborhoods.createIterator();
        for(iterator.first();iterator.isContinue();iterator.next()){
            iterator.currentItem().display(depth+2);
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public int getTotalIsFaultSensors() {
        int total = 0;
        ICityIterator iterator = _neighborhoods.createIterator();

        for(iterator.first();iterator.isContinue();iterator.next()){
            total+=iterator.currentItem().getTotalIsFaultSensors();
        }

        return total;
    }
}
