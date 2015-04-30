package repositories;

import domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import util.ItemCategory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ugo on 30/04/2015.
 */
public interface ItemRepository extends JpaRepository<Item, Serializable> {

    public List<Item> findByBarcodeNumber(String barccodeNumber);
    public List<Item> findByItemCategory(ItemCategory itemCategory);
    public List<Item> findByItemName(String itemName);
//    public List<Item> findByItemCostGreaterThan(double cost);
}
