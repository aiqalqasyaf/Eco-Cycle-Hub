/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author Aiqal
 */
public class BikeBean {
    private int bikeId;
    private String type;
    private String color;
    private String registrationDate;
    private String status;
    private String ownershipType;
    
    public BikeBean() {
        this.type = "";
        this.color = "";
        this.registrationDate = "";
        this.status = "";
        this.ownershipType = "";
    }

    public BikeBean(String type, String color, String registrationDate, String status, String ownershipType) {
        this.type = type;
        this.color = color;
        this.registrationDate = registrationDate;
        this.status = status;
        this.ownershipType = ownershipType;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }
    
    
    
}
