package com.dkit.oop;

import java.util.ArrayList;
import java.util.Objects;

// ***************************************SOLUTION ****************************************

public class Property
{
    private int propertyID;
    private String owner;
    private String postcode;
    private double sellingPrice;
    private double area;
    private static int sequence = 0;
    private ArrayList<String> facilities;

 //   public Property(int propertyID, String owner, String postcode, double sellingPrice, double area)
    public Property( String owner, String postcode, double sellingPrice, double area)
    {
        this.propertyID = ++sequence;
        this.owner = owner;
        this.postcode = postcode;
        this.sellingPrice = sellingPrice;
        this.area = area;
    }

    public Property( String owner, String postcode, double area)
    {
        this.propertyID = ++sequence;
        this.owner = owner;
        this.postcode = postcode;
        this.sellingPrice = 50000.00;  // some default value
        this.area = area;
    }

    public void addFacility(String facility) {
        facilities.add(facility);
    }

    public void removeFacility(String facility) {
        facilities.remove(facility);
    }

    public double calculateTax() {
        return this.area* 2.2 + 15;  // should create constant
    }


    public int getPropertyID()
    {
        return propertyID;
    }

    public void setPropertyID(int propertyID)
    {
        this.propertyID = propertyID;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public double getSellingPrice()
    {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice)
    {
        this.sellingPrice = sellingPrice;
    }

    public double getArea()
    {
        return area;
    }

    public void setArea(double area)
    {
        this.area = area;
    }


    @Override
    public String toString() {
        return "Property{" +
                "propertyID=" + propertyID +
                ", owner='" + owner + '\'' +
                ", postcode='" + postcode + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", area=" + area +
                ", facilities=" + facilities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return propertyID == property.propertyID &&
                Objects.equals(owner, property.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyID, owner);
    }
}
