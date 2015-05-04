package domain;


import util.ItemCategory;

import javax.persistence.*;

/**
 * Created by Ugo on 30/04/2015.
 */
@Entity
@Table(name = "items")
public class Item extends AbstractModel{

    private String itemName;
    private String barcodeNumber;
    private int quantityInStock;
    private int addNewQuantity;
    private double itemCost;
    @ManyToOne
    private Organization organization;
    @Enumerated(EnumType.STRING)
    private ItemCategory itemCategory;
    private String itemImageId;
    private double discountPercentage;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBarcodeNumber() {
        return barcodeNumber;
    }

    public void setBarcodeNumber(String barcodeNumber) {
        this.barcodeNumber = barcodeNumber;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getAddNewQuantity() {
        return addNewQuantity;
    }

    public void setAddNewQuantity(int addNewQuantity) {
        this.addNewQuantity = addNewQuantity;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemImageId() {
        return itemImageId;
    }

    public void setItemImageId(String itemImageId) {
        this.itemImageId = itemImageId;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}