package Iterator;

import Composite.INeighborhood;

/*Iterator Pattern =>
    Nesne bütünü içerisindeki elemanlarının nasıl yapılandıklarının bir önemi yoktur.Desenin
    amacı söz konusu nesne bütünü bastan sona dolasabilmektedir.

*/
//Iterator => Nesnein nasıl hareket etmesi gerektiği gibi kriterlerin sorumluluklarını Iterator nesnesine yükler
public interface ICityIterator {
    void first();
    boolean isContinue();
    void next();
    INeighborhood currentItem();
}
