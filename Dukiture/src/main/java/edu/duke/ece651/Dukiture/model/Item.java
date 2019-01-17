package edu.duke.ece651.Dukiture.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "item")
public class Item {
    private Long id;
    private double price;
    private String itemName;
    private String description;
    private String ownerUsername;
    private String contactInfo;
    private String imagePath;
    private String address;
    private User user;
    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    @ManyToOne
    @JoinColumn(name="user_id")
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOwnerUsername() {
        return this.ownerUsername;
    }
    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", price=" + price +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", ownerUsername='" + ownerUsername + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
