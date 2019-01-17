package edu.duke.ece651.Dukiture.model;

import java.util.Date;

public class ItemForm {

    private String description;
    private String ownerUsername;
    private String itemName;
    private String contactInfo;
    private String address;
    private double price;
    private long id;
    private Date date;

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ItemForm{" +
                "description='" + description + '\'' +
                ", ownerUsername='" + ownerUsername + '\'' +
                ", itemName='" + itemName + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
